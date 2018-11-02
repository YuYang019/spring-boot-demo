package com.example.sell.dto;

import com.example.sell.model.OrderDetail;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Author: maoyuyang
 * @Description: order data transfer object，订单数据传输对象
 * @Date: 18:13 18/11/1
 */
@Data
public class OrderDTO {

    private String orderId;

    private String buyerName;

    private String buyerPhone;

    private String buyerAddress;

    private String buyerOpenid;

    private BigDecimal orderAmount;

    private Integer orderStatus;

    private Integer payStatus;

    private Date createTime;

    private Date updateTime;

    List<CartDTO> cartDTOList;
}
