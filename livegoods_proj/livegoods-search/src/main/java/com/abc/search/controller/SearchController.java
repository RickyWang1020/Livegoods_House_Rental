package com.abc.search.controller;


import com.abc.commons.result.LivegoodsResult;
import com.abc.search.service.ISearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private ISearchService iSearchService;

    /**
     * search
     * @param city
     * @param content
     * @param page
     * @param size
     * @return
     */
    @GetMapping("")
    public LivegoodsResult search(String city, String content, int page, @RequestParam(defaultValue = "2") int size) {
        return iSearchService.search(city, content, page, size);
    }
}
