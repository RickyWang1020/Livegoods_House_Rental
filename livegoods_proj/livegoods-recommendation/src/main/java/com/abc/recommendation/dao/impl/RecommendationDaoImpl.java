package com.abc.recommendation.dao.impl;

import com.abc.pojo.Item;
import com.abc.recommendation.dao.RecommendationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RecommendationDaoImpl implements RecommendationDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * query for the list of hot-selling product recommendation
     * @param query
     * @return
     */
    public List<Item> selectRecommendationList(Query query) {
        return mongoTemplate.find(query, Item.class);
    }

}
