package com.example.sell.enums;

import lombok.Getter;

/**
 * @Author: maoyuyang
 * @Description:
 * @Date: 16:12 18/11/2
 */
@Getter
public enum ResultEnum {

    PRODUCT_NOT_EXIST(10, "商品不存在"),
    PRODUCT_STOCK_ERROR(11, "库存不足")
    ;

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
