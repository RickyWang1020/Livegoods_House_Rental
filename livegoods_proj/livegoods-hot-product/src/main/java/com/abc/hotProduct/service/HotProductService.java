package com.abc.hotProduct.service;

import com.abc.commons.result.LivegoodsResult;

public interface HotProductService {

    LivegoodsResult selectHotProductList(String city);
}
