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
    PRODUCT_STOCK_ERROR(11, "库存不足"),
    ORDER_NO_EXIST(12, "订单不存在"),
    ORDER_DETAIL_NO_EXIST(13, "订单详情不存在"),
    ORDER_STATUS_ERROR(14, "订单状态错误"),
    ORDER_UPDATE_ERROR(15, "订单更新错误"),
    ORDER_DETAIL_EMPTY(16, "订单中商品详情为空"),
    ORDER_PAY_STATUS_ERROR(17, "订单支付状态错误")
    ;

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
