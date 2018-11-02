package com.example.sell.service.impl;

import com.example.sell.dto.OrderDTO;
import com.example.sell.service.OrderService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @Author: maoyuyang
 * @Description: 订单service实现类
 * @Date: 18:19 18/11/1
 */
public class OrderServiceImpl implements OrderService {

    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO findOne(String orderId) {
        return null;
    }

    @Override
    public Page<OrderDTO> findList(String buyerOpenid, Pageable pageable) {
        return null;
    }

    @Override
    public OrderDTO cancel(String orderId) {
        return null;
    }

    @Override
    public OrderDTO finish(String orderId) {
        return null;
    }

    @Override
    public OrderDTO paid(String orderId) {
        return null;
    }
}
