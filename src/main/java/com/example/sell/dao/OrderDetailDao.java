package com.example.sell.dao;

import com.example.sell.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: maoyuyang
 * @Description: 订单详情dao
 * @Date: 17:12 18/11/1
 */
public interface OrderDetailDao extends JpaRepository<OrderDetail, String> {

    List<OrderDetail> findByOrderId(String orderId);
}
