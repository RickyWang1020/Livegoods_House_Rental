package com.abc.search.dao;

import com.abc.search.pojo.ItemES;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;

import java.util.List;

public interface ItemESDao {

    /**
     * insert and save by batches
     */
    void saveBatch(List<ItemES> itemESList);

    /**
     * insert and save for single item
     */
    void save(ItemES itemES);

    /**
     * search
     * @param query
     * @return
     */
    SearchHits<ItemES> search(NativeSearchQuery query);
}
