package com.abc.search.dao.impl;

import com.abc.pojo.Item;
import com.abc.search.dao.ItemESDao;
import com.abc.search.pojo.ItemES;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
public class ItemESTest {

    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private ItemESDao itemESDao;
    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Test
    public void testSave() {
        List<Item> itemList = mongoTemplate.findAll((Item.class));
//        List<ItemES> itemESList = new ArrayList<>();
//        for (Item item: itemList) {
//            ItemES i = new ItemES();
//            i.setId(item.getId());
//            i.setTitle(item.getTitle());
//            i.setCity(item.getCity());
//            i.setHouseType(item.getHouseTypeForSearch());
//            i.setImg(item.getImg());
//            i.setPrice("<h3>" + item.getPrice() + "</h3>");
//            i.setRentType(item.getRentType());
//            itemESList.add(i);
//        }
        List<ItemES> itemESList = itemList.stream().map(item -> new ItemES(item.getId(),
                                                                           item.getRentType(),
                                                                           "<h3>" + item.getPrice() + "</h3>",
                                                                           item.getHouseTypeForSearch(),
                                                                           item.getImg(),
                                                                           item.getTitle(),
                                                                           item.getCity()
                                                                           )).collect(Collectors.toList());
        itemESDao.saveBatch((itemESList));
    }

    @Test
    public void testSearch() {

        // highlight object
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.field("title").preTags("<span style='color:red'>").postTags("</span>");

        // construct the query builder
        BoolQueryBuilder queryBuilder = new BoolQueryBuilder();
        // must select
        List<QueryBuilder> must = queryBuilder.must();
        must.add(QueryBuilders.matchQuery("city", "北京"));
        // optional (should) select
        List<QueryBuilder> should = queryBuilder.should();
        should.add(QueryBuilders.matchQuery("title", "北京"));
        should.add(QueryBuilders.matchQuery("houseType", "北京"));
        should.add(QueryBuilders.matchQuery("rentType", "北京"));

        NativeSearchQuery query = new NativeSearchQueryBuilder()
                .withQuery(queryBuilder)
                .withHighlightBuilder(highlightBuilder)
                .withPageable(PageRequest.of(0, 2))
                .build();
        SearchHits<ItemES> searches = elasticsearchRestTemplate.search(query, ItemES.class);
        List<ItemES> list = new ArrayList<>();
        for (SearchHit<ItemES> search : searches) {
            ItemES itemES = search.getContent();
            if (search.getHighlightFields().containsKey("title")) {
                itemES.setTitle(search.getHighlightFields().get("title").get(0));
            }
            list.add(itemES);
        }
        System.out.println(list);
        // check if there are still more data afterwards
        if (list.size() > 2) {
            System.out.println(true);
        }
    }
}