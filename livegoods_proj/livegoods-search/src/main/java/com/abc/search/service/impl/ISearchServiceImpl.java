package com.abc.search.service.impl;

import com.abc.commons.result.LivegoodsResult;
import com.abc.search.dao.ItemESDao;
import com.abc.search.pojo.ItemES;
import com.abc.search.service.ISearchService;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ISearchServiceImpl implements ISearchService {

    @Autowired
    private ItemESDao itemESDao;

    /**
     * search
     * @param city
     * @param content
     * @param page
     * @param size
     * @return
     */
    @Override
    public LivegoodsResult search(String city, String content, int page, int size) {
        // highlight object
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.field("title").preTags("<span style='color:red'>").postTags("</span>");

        // construct the query builder
        BoolQueryBuilder queryBuilder = new BoolQueryBuilder();
        // must select
        List<QueryBuilder> must = queryBuilder.must();
        must.add(QueryBuilders.matchQuery("city", city));
        // optional (should) select
        List<QueryBuilder> should = queryBuilder.should();
        should.add(QueryBuilders.matchQuery("title", content));
        should.add(QueryBuilders.matchQuery("houseType", content));
        should.add(QueryBuilders.matchQuery("rentType", content));

        NativeSearchQuery query = new NativeSearchQueryBuilder()
                .withQuery(queryBuilder)
                .withHighlightBuilder(highlightBuilder)
                .withPageable(PageRequest.of(0, 2))
                .build();
        SearchHits<ItemES> searches = itemESDao.search(query);
        List<ItemES> list = new ArrayList<>();
        for (SearchHit<ItemES> search : searches) {
            ItemES itemES = search.getContent();
            if (search.getHighlightFields().containsKey("title")) {
                itemES.setTitle(search.getHighlightFields().get("title").get(0));
            }
            list.add(itemES);
        }
        LivegoodsResult livegoodsResult = LivegoodsResult.success("successful query", list);
        System.out.println(list);
        // check if there are still more data afterwards
        if (searches.getTotalHits() > (page + 1) * size) {
            livegoodsResult.setHasMore(true);
        }
        return livegoodsResult;
    }
}
