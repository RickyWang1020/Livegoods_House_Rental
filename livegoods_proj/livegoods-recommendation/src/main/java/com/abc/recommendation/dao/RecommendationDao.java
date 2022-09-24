package com.abc.recommendation.dao;

import com.abc.pojo.Item;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

public interface RecommendationDao {

    /**
     * query for the list of hot-selling product recommendation
     * @param query
     * @return
     */
    List<Item> selectRecommendationList(Query query);
}
