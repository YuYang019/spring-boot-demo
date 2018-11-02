package com.example.sell.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Data
public class ProductInfo {

    @Id
    private String productId;

    // 商品名称
    private String productName;

    // 商品价格
    private BigDecimal productPrice;

    // 商品库存
    private Integer productStock;

    // 商品描述
    private String productDescription;

    // 商品图标
    private String productIcon;

    // 0正常，1下架
    private Integer productStatus;

    // 商品类别
    private Integer categoryType;
}
