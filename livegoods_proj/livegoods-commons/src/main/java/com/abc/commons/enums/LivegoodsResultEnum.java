package com.abc.commons.enums;

/**
 * Create an enum class
 * 1. improve readability, avoid hard coding
 * 2. Decoupling the program
*/

public enum LivegoodsResultEnum {

    // define the enum class
    SUCCESS(200, "success"),
    ERROR(500, "error");

    private Integer status;
    private String msg;

    LivegoodsResultEnum(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }



}
