package com.abc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    private String id;                  // primary key
    private String title;               // title
    private String img;                 //
    private String link;                // link for redirection
    private Long sales;                 // the sales number
    private String houseType;           // the
    private String price;               // the price number
    private String rentType;            //
    private List<String> imgs;          //
    private Map<String, String> info;   // 
}
