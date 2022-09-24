package com.abc.hotProduct.service.impl;

import com.abc.commons.result.LivegoodsResult;
import com.abc.hotProduct.HotProduct;
import com.abc.hotProduct.dao.HotProductDao;
import com.abc.hotProduct.service.HotProductService;
import com.abc.pojo.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotProductServiceImpl implements HotProductService {

    @Autowired
    private HotProductDao hotProductDao;
    @Value("${fastdfs.storage.nginx.prefix:}")
    private String fastdfsNginxPrefix;

    /**
     * query for the list of hot-selling products
     * 1. query for the list of all products in the city, sort by the sales, and pick the top 4
     * 2. if there is fewer than 4 products in this city, pick from other city's hot products and fill in the slot
     */
    @Override
    public LivegoodsResult selectHotProductList(String city) {
        Query query = new Query();
        // query for "where city = ..."
        query.addCriteria(Criteria.where("city").is(city));
        // descending sort the sales and pick the top 4
        query.with(PageRequest.of(0, 4, Sort.by(Sort.Order.desc("sales"))));
        List<Item> list = hotProductDao.selectHotProductList(query);
        if (list.size() < 4) {
            Query otherQuery = new Query();
            // query for "where city <> ..."
            otherQuery.addCriteria(Criteria.where("city").ne(city));
            otherQuery.with(PageRequest.of(0, 4-list.size(), Sort.by(Sort.Order.desc("sales"))));
            List<Item> otherList = hotProductDao.selectHotProductList(otherQuery);
            list.addAll(otherList);
        }
        List<Item> finalList = changeUrls(list);
        return LivegoodsResult.success("successful query", finalList);
    }

    // complete the urls for the images by adding the prefix
    private List<Item> changeUrls(List<Item> list) {
//        for (Item item : list) {
//            List<String> imgs = item.getImgs();
//            List<String> imgUrls = new ArrayList<>();
//            for (String img : imgs) {
//                imgUrls.add(fastdfsNginxPrefix + img);
//            }
//            item.setImgs(imgUrls);
//        }
        list.forEach(
                item -> item.setImgs(item.getImgs().stream().map(img -> fastdfsNginxPrefix + img).collect(Collectors.toList()))
        );
        return list;
    }
}
