package com.abc.productDetails.service.impl;

import com.abc.commons.result.LivegoodsResult;
import com.abc.pojo.Item;
import com.abc.productDetails.dao.ProductDetailsDao;
import com.abc.productDetails.service.ProductDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class ProductDetailsServiceImpl implements ProductDetailsService {

    @Autowired
    private ProductDetailsDao productDetailsDao;
    @Value("${fastdfs.storage.nginx.prefix:}")
    private String fastdfsNginxPrefix;

    /**
     * product details
     * @param id
     * @return
     */
    @Override
    public Item selectItemById(String id) {
        Item item = productDetailsDao.selectItemById(id);
        item.setImgs(
                item.getImgs().stream().map(img -> fastdfsNginxPrefix + img).collect(Collectors.toList())
        );
        return item;
    }
}
