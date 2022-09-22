package com.abc.mongodb;

import com.abc.pojo.Banner;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@SpringBootTest(classes = {MongoApplication.class})
// the filename of yml is not application.yml, so need to configure manually here
@ActiveProfiles("mongodb")
public class MongoApplicationTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void insertBanner() {

        // test the insertion of multiple lines of data
        List<Banner> lst = new ArrayList<>();
        Banner banner1 = new Banner();
        banner1.setCreateTime(new Date());
        banner1.setUrl("group1/M00/00/00/wKg5A2MrjJeAfGoAABLGy4zg5nA493.png");
        Banner banner2 = new Banner();
        banner2.setCreateTime(new Date());
        banner2.setUrl("group1/M00/00/00/wKg5A2MrjJ2ATgm1AAjIobLVxBY871.png");
        Banner banner3 = new Banner();
        banner3.setCreateTime(new Date());
        banner3.setUrl("group1/M00/00/00/wKg5A2MrjKCAYU8GAAro9yfjOVw568.png");
        Banner banner4 = new Banner();
        banner4.setCreateTime(new Date());
        banner4.setUrl("group1/M00/00/00/wKg5A2MrjNaATFtdAAuC467ZRns890.png");
        Banner banner5 = new Banner();
        banner5.setCreateTime(new Date());
        banner5.setUrl("group1/M00/00/00/wKg5A2MrjNmAdC-pABS0Lvm4RSc022.png");
        Banner banner6 = new Banner();
        banner6.setCreateTime(new Date());
        banner6.setUrl("group1/M00/00/00/wKg5A2MrjNyAaOhEABHVENCjbfU001.png");
        lst.add(banner1);
        lst.add(banner2);
        lst.add(banner3);
        lst.add(banner4);
        lst.add(banner5);
        lst.add(banner6);
        Collection<Banner> result = mongoTemplate.insert(lst, Banner.class);
        System.out.println(result);
    }
}