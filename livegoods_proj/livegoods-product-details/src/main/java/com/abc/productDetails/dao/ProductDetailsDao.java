package com.abc.productDetails.dao;

import com.abc.pojo.Item;

public interface ProductDetailsDao {

    /**
     * product details
     * @param id
     * @return
     */
    Item selectItemById(String id);
}
