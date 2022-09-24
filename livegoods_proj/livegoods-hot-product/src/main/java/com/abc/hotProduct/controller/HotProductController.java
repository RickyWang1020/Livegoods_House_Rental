package com.abc.hotProduct.controller;

import com.abc.commons.result.LivegoodsResult;
import com.abc.hotProduct.HotProduct;
import com.abc.hotProduct.service.HotProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * controller level for hot-selling product service
 */
@RestController
@RequestMapping("/hotProduct")
public class HotProductController {

    @Autowired
    private HotProductService hotProductService;

    /**
     * query for the hot-selling product list
     */
    @GetMapping("")
    public LivegoodsResult selectHotProductList(String city) {
        return hotProductService.selectHotProductList(city);
    }
}
