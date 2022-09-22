package com.abc.banner.dao.impl;

import com.abc.banner.dao.BannerDao;
import com.abc.pojo.Banner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BannerDaoImpl implements BannerDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * query for the list of pojo rolling images
     */
    @Override
    public List<Banner> selectBannerList(Query query) {
        return mongoTemplate.find(query, Banner.class);
    }
}
