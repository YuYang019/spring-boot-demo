package com.example.sell.service.VO;

import lombok.Data;

/**
 * @Author: maoyuyang
 * @Description: view object 视图对象，定义用于返回给前端的最外层的数据结构
 * @Date: 18:56 18/10/31
 */
@Data
public class ResultVO<T> {

    // 错误码
    private Integer code;

    // 提示信息
    private String msg;

    // 返回的具体内容
    private T data;
}
