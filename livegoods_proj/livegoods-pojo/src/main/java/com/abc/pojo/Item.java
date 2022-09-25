package com.abc.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@EqualsAndHashCode
@Data
@NoArgsConstructor
public class Item implements Serializable {

    private String id;                  // primary key
    private String title;               // title
//    private String img;                 // the image of the product, an inferred attribute
//    private String link;                // link for redirection, an inferred attribute
    private Long sales;                 // the sales number
    private Boolean recommendation;     // whether it is a hot-selling product
    private Byte recoSort;              // the weight that decides how to sort and list the hot-selling product
    private String city;                // the city where the product belongs to
    private Long price;                 // the price number
    private String houseType;           // the floor, type, and area of the house
    private String rentType;            // the way of rent, single-rent, share-rent, etc.
    private List<String> imgs;          // the list of all images' links
    private Map<String, String> info;   // 房屋特性， Map集合。集合存储数据内容为： years: "建造年份", type: "房屋类型，几室几厅", level: "所在楼层", style: "装修标准", orientation: "房屋朝向"

    public String getImg() {
        return imgs.get(0);
    }

    public void setImg(String img) {
    }

    public String getLink() {
        return "/details/" + id; // 商品详情接口
    }

    public void setLink(String link) {
    }

    public String getHouseTypeForSearch() {
        // "楼层 | 几室几厅 - 面积"
        return info.get("level") + " | " + info.get("type") + " - " + houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getSales() {
        return sales;
    }

    public void setSales(Long sales) {
        this.sales = sales;
    }

    public Boolean getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(Boolean recommendation) {
        this.recommendation = recommendation;
    }

    public Byte getRecoSort() {
        return recoSort;
    }

    public void setRecoSort(Byte recoSort) {
        this.recoSort = recoSort;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getRentType() {
        return rentType;
    }

    public void setRentType(String rentType) {
        this.rentType = rentType;
    }

    public String getHouseType() {
        return houseType;
    }

    public Map<String, String> getInfo() {
        return info;
    }

    public void setInfo(Map<String, String> info) {
        this.info = info;
    }

    public List<String> getImgs() {
        return imgs;
    }

    public void setImgs(List<String> imgs) {
        this.imgs = imgs;
    }

}
