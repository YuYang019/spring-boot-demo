package com.example.sell.exception;

import com.example.sell.enums.ResultEnum;

/**
 * @Author: maoyuyang
 * @Description: 自定义错误类，在自带抛错api上做了一层封装
 * @Date: 16:11 18/11/2
 */
public class SellException extends RuntimeException{

    private Integer code;

    public SellException(ResultEnum resultEnum) {
        // 自带一个msg的参数
        super(resultEnum.getMsg());

        this.code = resultEnum.getCode();
    }
}
