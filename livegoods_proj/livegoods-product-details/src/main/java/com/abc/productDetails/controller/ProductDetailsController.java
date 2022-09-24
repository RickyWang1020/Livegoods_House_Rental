package com.abc.productDetails.controller;

import com.abc.commons.result.LivegoodsResult;
import com.abc.pojo.Item;
import com.abc.productDetails.ProductDetailsApplication;
import com.abc.productDetails.service.ProductDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/details")
public class ProductDetailsController {

    @Autowired
    private ProductDetailsService productDetailsService;

    /**
     * product details
     * @param id
     * @return
     */
    @GetMapping("")
    public Item selectItemById(String id) {
        return productDetailsService.selectItemById(id);
    }
}
