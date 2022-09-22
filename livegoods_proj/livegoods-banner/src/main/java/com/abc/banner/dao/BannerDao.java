package com.abc.banner.dao;

import com.abc.pojo.Banner;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

public interface BannerDao {

    /**
     * query for the list of pojo rolling images
     */
    List<Banner> selectBannerList(Query query);
}
