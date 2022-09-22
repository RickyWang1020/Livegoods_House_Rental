package com.abc.banner.controller;

import com.abc.banner.service.BannerService;
import com.abc.commons.result.LivegoodsResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/banner")
public class BannerController {

    @Autowired
    private BannerService bannerService;

    /**
     * get the list of Banner, for the rolling display of pictures on the page
     * returns a json
     * success：{"status": 200, "results": ["addr1","addr2","addr3"]}
     * failed：{"status": 400, "msg": "error msg"}
     */
    @RequestMapping("")
    @ResponseBody
    public LivegoodsResult selectBannerList() {
        return bannerService.selectBannerList();
    }
}
