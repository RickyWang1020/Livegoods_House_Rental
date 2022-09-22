package com.abc.banner.service;

import com.abc.commons.result.LivegoodsResult;

public interface BannerService {
    /**
     * query for the list of pojo rolling images
     */
    LivegoodsResult selectBannerList();
}
