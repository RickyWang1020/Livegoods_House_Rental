package com.abc.hotProduct.dao;

import com.abc.pojo.Item;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

public interface HotProductDao {

    List<Item> selectHotProductList(Query query);
}
