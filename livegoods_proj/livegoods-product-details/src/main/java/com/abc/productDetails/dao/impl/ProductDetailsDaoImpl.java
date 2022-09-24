package com.abc.productDetails.dao.impl;

import com.abc.pojo.Item;
import com.abc.productDetails.dao.ProductDetailsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDetailsDaoImpl implements ProductDetailsDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * product details
     * @param id
     * @return
     */
    @Override
    public Item selectItemById(String id) {
        return mongoTemplate.findById(id, Item.class);
    }
}
