package com.abc.banner.service.impl;

import com.abc.banner.dao.BannerDao;
import com.abc.banner.service.BannerService;
import com.abc.commons.result.LivegoodsResult;
import com.abc.pojo.Banner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BannerServiceImpl implements BannerService {

    @Autowired
    private BannerDao bannerDao;

    @Value("${fastdfs.storage.nginx.prefix}")
    private String fastdfsNginxPrefix;

    @Override
    public LivegoodsResult selectBannerList() {
        Query query = new Query();
        // create criteria: based on the time that the picture was created, take 6 of them in descending order
        query.with(PageRequest.of(0, 6, Sort.by(Sort.Order.desc("createTime"))));
        List<Banner> banners = bannerDao.selectBannerList(query);
        if (banners == null || banners.isEmpty()) {
            return LivegoodsResult.error("query error");
        }
//        List<String> imgUrls = new ArrayList<>();
//        for (Banner b: banners) {
//            imgUrls.add(b.getUrl());
//        }
        List<String> imgUrls = banners.stream().map(banner -> fastdfsNginxPrefix + banner.getUrl()).collect(Collectors.toList());
        return LivegoodsResult.success("query success", imgUrls);
    }
}
