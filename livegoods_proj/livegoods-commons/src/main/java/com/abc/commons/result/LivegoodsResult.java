package com.abc.commons.result;

import com.abc.commons.enums.LivegoodsResultEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LivegoodsResult {

    private Integer status;
    private Object data;
    private String msg;
    private Boolean hasMore;

    public static LivegoodsResult success() {
        return new LivegoodsResult(LivegoodsResultEnum.SUCCESS.getStatus(), null, LivegoodsResultEnum.SUCCESS.getMsg(), false);
    }

    public static LivegoodsResult success(String msg) {
        return new LivegoodsResult(LivegoodsResultEnum.SUCCESS.getStatus(), null, msg, false);
    }

    public static LivegoodsResult success(String msg, Object data) {
        return new LivegoodsResult(LivegoodsResultEnum.SUCCESS.getStatus(), data, msg, false);
    }

    public static LivegoodsResult error() {
        return new LivegoodsResult(LivegoodsResultEnum.ERROR.getStatus(), null, LivegoodsResultEnum.ERROR.getMsg(), false);
    }

    public static LivegoodsResult error(String msg) {
        return new LivegoodsResult(LivegoodsResultEnum.ERROR.getStatus(), null, msg, false);
    }

    public static LivegoodsResult error(String msg, Object data) {
        return new LivegoodsResult(LivegoodsResultEnum.ERROR.getStatus(), data, msg, false);
    }
}
