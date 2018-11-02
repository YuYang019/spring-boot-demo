package com.example.sell.dto;

import lombok.Data;

/**
 * @Author: maoyuyang
 * @Description: 购物车
 * @Date: 17:09 18/11/2
 */
@Data
public class CartDTO {

    private String productId;

    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
