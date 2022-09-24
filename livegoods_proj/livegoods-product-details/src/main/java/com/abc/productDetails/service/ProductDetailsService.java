package com.abc.productDetails.service;

import com.abc.commons.result.LivegoodsResult;
import com.abc.pojo.Item;

public interface ProductDetailsService {

    /**
     * product details
     * @param id
     * @return
     */
    Item selectItemById(String id);

}
