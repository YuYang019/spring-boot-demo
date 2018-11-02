package com.example.sell.enums;

import lombok.Getter;

/**
 * @Author: maoyuyang
 * @Description: 订单状态枚举
 * @Date: 11:59 18/11/1
 */
@Getter
public enum OrderStatusEnum {

    NEW(0, "新订单"),
    FINISHED(1, "完结"),
    CANCEL(2, "已取消"),
    ;

    private Integer code;

    private String msg;

    OrderStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
