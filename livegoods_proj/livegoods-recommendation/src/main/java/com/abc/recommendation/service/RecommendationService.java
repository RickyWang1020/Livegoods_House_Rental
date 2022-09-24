package com.abc.recommendation.service;

import com.abc.commons.result.LivegoodsResult;

public interface RecommendationService {

    /**
     * query for the list of hot-selling product recommendation
     * @param city
     * @return
     */
    LivegoodsResult selectRecommendationList(String city);
}
