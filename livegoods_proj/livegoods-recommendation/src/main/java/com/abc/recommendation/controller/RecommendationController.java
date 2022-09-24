package com.abc.recommendation.controller;

import com.abc.commons.result.LivegoodsResult;
import com.abc.recommendation.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recommendation")
public class RecommendationController {

    @Autowired
    private RecommendationService recommendationService;

    /**
     * query for the list of hot-selling product recommendation
     * @param city
     * @return
     */
    @GetMapping("")
    public LivegoodsResult selectRecommendationList(String city) {
        return recommendationService.selectRecommendationList(city);
    }
}
