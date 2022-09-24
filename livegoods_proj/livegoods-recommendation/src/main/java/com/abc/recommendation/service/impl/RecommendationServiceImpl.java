package com.abc.recommendation.service.impl;

import com.abc.commons.result.LivegoodsResult;
import com.abc.pojo.Item;
import com.abc.recommendation.dao.RecommendationDao;
import com.abc.recommendation.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecommendationServiceImpl implements RecommendationService {

    @Autowired
    private RecommendationDao recommendationDao;
    @Value("${fastdfs.storage.nginx.prefix:}")
    private String fastdfsNginxPrefix;

    /**
     * query for the list of hot-selling product recommendation
     * @param city
     * @return
     */
    @Override
    public LivegoodsResult selectRecommendationList(String city) {

        Query query = new Query();
        Criteria criteria = new Criteria();
        // query conditions: where city = ... and recommendation = true
        criteria.andOperator(
                Criteria.where("city").is(city),
                Criteria.where("recommendation").is(true)
        );
        query.addCriteria(criteria);
        // descending sort by the recoSort field, as if it is sorting by some weights assigned by some data analysis
        query.with(PageRequest.of(0, 4, Sort.by(Sort.Order.desc("recoSort"))));
        List<Item> list = recommendationDao.selectRecommendationList(query);

        // the current city has fewer than 4 recommendations, fill in with other cities' products
        if (list.size() < 4) {
            Query otherQuery = new Query();
            Criteria otherCriteria = new Criteria();
            // query conditions: where city <> ... and recommendation = true
            otherCriteria.andOperator(
                    Criteria.where("city").ne(city),
                    Criteria.where("recommendation").is(true)
            );
            otherQuery.addCriteria(otherCriteria);
            otherQuery.with(PageRequest.of(0, 4- list.size(), Sort.by(Sort.Order.desc("recoSort"))));
            List<Item> otherList = recommendationDao.selectRecommendationList(otherQuery);
            list.addAll(otherList);
        }
        List<Item> finalList = changeUrls(list);
        return LivegoodsResult.success("successful query", finalList);
    }

    private List<Item> changeUrls(List<Item> list) {
        list.forEach(
                item -> item.setImgs(
                        item.getImgs().stream().map(img -> fastdfsNginxPrefix + img).collect(Collectors.toList())
                )
        );
        return list;
    }
}
