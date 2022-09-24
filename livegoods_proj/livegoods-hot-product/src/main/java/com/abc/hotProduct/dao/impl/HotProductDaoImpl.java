package com.abc.hotProduct.dao.impl;

import com.abc.hotProduct.dao.HotProductDao;
import com.abc.pojo.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HotProductDaoImpl implements HotProductDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Item> selectHotProductList(Query query) {
        return mongoTemplate.find(query, Item.class);
    }
}
