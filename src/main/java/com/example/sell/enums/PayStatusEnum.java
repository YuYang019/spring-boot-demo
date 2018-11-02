package com.example.sell.enums;

import lombok.Getter;

/**
 * @Author: maoyuyang
 * @Description: 支付状态枚举
 * @Date: 12:02 18/11/1
 */
@Getter
public enum PayStatusEnum {

    WAIT(0, "等待支付"),
    SUCCESS(1, "支付成功"),
    ;

    private Integer code;

    private String msg;

    PayStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
