package com.abc.mongodb;

import com.abc.pojo.Banner;
import com.abc.pojo.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ActiveProfiles;

import java.util.*;

@SpringBootTest(classes = {MongoApplication.class})
// the filename of yml is not application.yml, so need to configure manually here
@ActiveProfiles("mongodb")
public class MongoApplicationTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void testInsertBanner() {

        // test the insertion of multiple lines of data
        List<Banner> lst = new ArrayList<>();
        Banner banner1 = new Banner();
        banner1.setCreateTime(new Date());
        banner1.setUrl("group1/M00/00/00/wKg5A2MrjJeAfGoAABLGy4zg5nA493.jpg");
        Banner banner2 = new Banner();
        banner2.setCreateTime(new Date());
        banner2.setUrl("group1/M00/00/00/wKg5A2MrjJ2ATgm1AAjIobLVxBY871.jpg");
        Banner banner3 = new Banner();
        banner3.setCreateTime(new Date());
        banner3.setUrl("group1/M00/00/00/wKg5A2MrjKCAYU8GAAro9yfjOVw568.jpg");
        Banner banner4 = new Banner();
        banner4.setCreateTime(new Date());
        banner4.setUrl("group1/M00/00/00/wKg5A2MrjNaATFtdAAuC467ZRns890.jpg");
        Banner banner5 = new Banner();
        banner5.setCreateTime(new Date());
        banner5.setUrl("group1/M00/00/00/wKg5A2MrjNmAdC-pABS0Lvm4RSc022.jpg");
        Banner banner6 = new Banner();
        banner6.setCreateTime(new Date());
        banner6.setUrl("group1/M00/00/00/wKg5A2MrjNyAaOhEABHVENCjbfU001.jpg");
        lst.add(banner1);
        lst.add(banner2);
        lst.add(banner3);
        lst.add(banner4);
        lst.add(banner5);
        lst.add(banner6);
        Collection<Banner> result = mongoTemplate.insert(lst, Banner.class);
        System.out.println(result);
    }

    @Test
    public void testInsertHotProduct() {
        List<Item> items = new ArrayList<>();
        Item item = new Item();
        item.setCity("北京");
        item.setHouseType("150 ㎡");
        item.setImgs(
            Arrays.asList(
                "group1/M00/00/00/wKgKZl-WvreALQi4AAB-GeHTZKU686.jpg",
                "group1/M00/00/00/wKgKZl-WvsKAH_B9AAA5uaq_bgg746.jpg",
                "group1/M00/00/00/wKgKZl-WvsmAV36HAABj-XKH-yU736.jpg"
            )
        );
        item.setPrice(12000L);
        item.setRecommendation(true);
        item.setRecoSort((byte) 9);
        item.setRentType("整租");
        item.setSales(100L);
        item.setTitle("北京高档公寓");
        Map<String, String> info = new HashMap<>();
        info.put("years", "2010");
        info.put("type", "3室2厅");
        info.put("level", "10/18层");
        info.put("style", "精装修");
        info.put("orientation", "南北通透");
        item.setInfo(info);
        items.add(item);

        item = new Item();
        item.setCity("北京");
        item.setHouseType("230 ㎡");
        item.setImgs(
            Arrays.asList(
                "group1/M00/00/00/wKgKZl-WvtSAMaMZAABK2skrw6Y581.jpg",
                "group1/M00/00/00/wKgKZl-WvtyAMJZbAAB5HIBoq3U829.jpg",
                "group1/M00/00/00/wKgKZl-WvuKAS9GDAABI1PwAKtc930.jpg"
            )
        );
        item.setPrice(21000L);
        item.setRecommendation(true);
        item.setRecoSort((byte) 12);
        item.setRentType("整租");
        item.setSales(30L);
        info = new HashMap<>();
        info.put("years", "2007");
        info.put("type", "5室3厅");
        info.put("level", "2/2层");
        info.put("style", "精装修");
        info.put("orientation", "南北通透");
        item.setInfo(info);
        item.setTitle("北京联排别墅");
        items.add(item);

        item = new Item();
        item.setCity("北京");
        item.setHouseType("310 ㎡");
        item.setImgs(
            Arrays.asList(
                "group1/M00/00/00/wKgKZl-WvuKAS9GDAABI1PwAKtc930.jpg",
                "group1/M00/00/00/wKgKZl-WvumAfywEAABSeqIt9Y0233.jpg",
                "group1/M00/00/00/wKgKZl-WvvCAHhYPAAAy6h6_QUI921.jpg"
            )
        );
        item.setPrice(30000L);
        item.setRecommendation(true);
        item.setRecoSort((byte) 6);
        item.setRentType("整租");
        item.setSales(10L);
        info = new HashMap<>();
        info.put("years", "2013");
        info.put("type", "6室4厅");
        info.put("level", "3/3层");
        info.put("style", "豪华装修");
        info.put("orientation", "四面环海");
        item.setInfo(info);
        item.setTitle("北京独栋别墅");
        items.add(item);

        item = new Item();
        item.setCity("北京");
        item.setHouseType("60 ㎡");
        item.setImgs(
            Arrays.asList(
                "group1/M00/00/00/wKgKZl-WvreALQi4AAB-GeHTZKU686.jpg",
                "group1/M00/00/00/wKgKZl-WvsKAH_B9AAA5uaq_bgg746.jpg",
                "group1/M00/00/00/wKgKZl-WvsmAV36HAABj-XKH-yU736.jpg"
            )
        );
        item.setPrice(3000L);
        item.setRecommendation(true);
        item.setRecoSort((byte) 9);
        item.setRentType("整租");
        item.setSales(300L);
        info = new HashMap<>();
        info.put("years", "2000");
        info.put("type", "2室1厅");
        info.put("level", "6/6层");
        info.put("style", "简单装修");
        info.put("orientation", "朝南");
        item.setInfo(info);
        item.setTitle("北京老小区");
        items.add(item);

        item = new Item();
        item.setCity("上海");
        item.setHouseType("150 ㎡");
        item.setImgs(
            Arrays.asList(
                "group1/M00/00/00/wKgKZl-WvuKAS9GDAABI1PwAKtc930.jpg",
                "group1/M00/00/00/wKgKZl-WvumAfywEAABSeqIt9Y0233.jpg",
                "group1/M00/00/00/wKgKZl-WvvCAHhYPAAAy6h6_QUI921.jpg"
            )
        );
        item.setPrice(12000L);
        item.setRecommendation(true);
        item.setRecoSort((byte) 9);
        item.setRentType("整租");
        item.setSales(100L);
        item.setTitle("上海高档公寓");
        info = new HashMap<>();
        info.put("years", "2010");
        info.put("type", "3室2厅");
        info.put("level", "10/18层");
        info.put("style", "精装修");
        info.put("orientation", "南北通透");
        item.setInfo(info);
        items.add(item);

        item = new Item();
        item.setCity("上海");
        item.setHouseType("230 ㎡");
        item.setImgs(
            Arrays.asList(
                "group1/M00/00/00/wKgKZl-WvtSAMaMZAABK2skrw6Y581.jpg",
                "group1/M00/00/00/wKgKZl-WvtyAMJZbAAB5HIBoq3U829.jpg",
                "group1/M00/00/00/wKgKZl-WvuKAS9GDAABI1PwAKtc930.jpg"
            )
        );
        item.setPrice(21000L);
        item.setRecommendation(true);
        item.setRecoSort((byte) 12);
        item.setRentType("整租");
        item.setSales(30L);
        info = new HashMap<>();
        info.put("years", "2007");
        info.put("type", "5室3厅");
        info.put("level", "2/2层");
        info.put("style", "精装修");
        info.put("orientation", "南北通透");
        item.setInfo(info);
        item.setTitle("上海联排别墅");
        items.add(item);

        item = new Item();
        item.setCity("上海");
        item.setHouseType("310 ㎡");
        item.setImgs(
            Arrays.asList(
                "group1/M00/00/00/wKgKZl-WvtSAMaMZAABK2skrw6Y581.jpg",
                "group1/M00/00/00/wKgKZl-WvtyAMJZbAAB5HIBoq3U829.jpg",
                "group1/M00/00/00/wKgKZl-WvuKAS9GDAABI1PwAKtc930.jpg"
            )
        );
        item.setPrice(30000L);
        item.setRecommendation(true);
        item.setRecoSort((byte) 6);
        item.setRentType("整租");
        item.setSales(10L);
        info = new HashMap<>();
        info.put("years", "2013");
        info.put("type", "6室4厅");
        info.put("level", "3/3层");
        info.put("style", "豪华装修");
        info.put("orientation", "四面环海");
        item.setInfo(info);
        item.setTitle("上海独栋别墅");
        items.add(item);

        item = new Item();
        item.setCity("上海");
        item.setHouseType("60 ㎡");
        item.setImgs(
            Arrays.asList(
                "group1/M00/00/00/wKgKZl-WvtSAMaMZAABK2skrw6Y581.jpg",
                "group1/M00/00/00/wKgKZl-WvtyAMJZbAAB5HIBoq3U829.jpg",
                "group1/M00/00/00/wKgKZl-WvuKAS9GDAABI1PwAKtc930.jpg"
            )
        );
        item.setPrice(3000L);
        item.setRecommendation(true);
        item.setRecoSort((byte) 9);
        item.setRentType("整租");
        item.setSales(300L);
        info = new HashMap<>();
        info.put("years", "2000");
        info.put("type", "2室1厅");
        info.put("level", "6/6层");
        info.put("style", "简单装修");
        info.put("orientation", "朝南");
        item.setInfo(info);
        item.setTitle("上海老小区");
        items.add(item);

        Collection<Item> result = mongoTemplate.insert(items, Item.class);
        System.out.println(result);
    }
}