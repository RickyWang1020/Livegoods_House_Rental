package com.abc.pojo;

import java.util.Date;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Banner {
    // primary key indicating the id of pictures
    private String id;
    // url of pictures
    private String url;
    // the time that pictures were created
    private Date createTime;
}
