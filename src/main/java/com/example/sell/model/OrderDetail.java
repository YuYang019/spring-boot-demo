package com.example.sell.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.List;

/**
 * @Author: maoyuyang
 * @Description: 订单详情
 * @Date: 12:06 18/11/1
 */
@Entity
@Data
public class OrderDetail {

    @Id
    private String detailId;

    private String orderId;

    private String productId;

    private String productName;

    private BigDecimal productPrice;

    private Integer productQuantity;

    private String productIcon;

    private List<OrderDetail> orderDetailList;
}
