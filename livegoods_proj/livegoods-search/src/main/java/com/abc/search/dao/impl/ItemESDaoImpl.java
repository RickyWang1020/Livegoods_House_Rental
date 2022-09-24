package com.abc.search.dao.impl;

import com.abc.search.dao.ItemESDao;
import com.abc.search.pojo.ItemES;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemESDaoImpl implements ItemESDao {

    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    /**
     * insert and save by batches
     */
    @Override
    public void saveBatch(List<ItemES> itemESList) {
        elasticsearchRestTemplate.save(itemESList);
    }

    /**
     * insert and save for single item
     */
    @Override
    public void save(ItemES itemES) {
        saveBatch(List.of(itemES));
    }

    /**
     * search
     * @param query
     * @return
     */
    @Override
    public SearchHits<ItemES> search(NativeSearchQuery query) {
        return elasticsearchRestTemplate.search(query, ItemES.class);
    }
}
