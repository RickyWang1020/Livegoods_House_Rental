package com.abc.search.service;

import com.abc.commons.result.LivegoodsResult;

public interface ISearchService {

    /**
     * search
     * @param city
     * @param content
     * @param page
     * @param size
     * @return
     */
    LivegoodsResult search(String city, String content, int page, int size);
}
