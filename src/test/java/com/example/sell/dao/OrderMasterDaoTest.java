package com.example.sell.dao;

import com.example.sell.model.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @Author: maoyuyang
 * @Description: 订单详情dao测试
 * @Date: 17:15 18/11/1
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterDaoTest {

    @Autowired
    private OrderMasterDao repository;

    private final String OPENID = "110110";

    @Test
    public void saveTest() {
        OrderMaster om = new OrderMaster();
        om.setOrderId("12345");
        om.setBuyerAddress("asdasdqw");
        om.setBuyerName("maoyuyang");
        om.setBuyerPhone("1214123123");
        om.setBuyerOpenid("110110");
        om.setOrderAmount(new BigDecimal(2.3));

        OrderMaster result = repository.save(om);

        Assert.assertNotNull(result);
    }

    @Test
    public void updateTest() {
        OrderMaster om = repository.findById("123456").get();

        om.setBuyerName("毛宇阳");

        OrderMaster result = repository.save(om);

        Assert.assertNotNull(result);
    }

    @Test
    public void findByBuyerOpenid() {
        PageRequest request = PageRequest.of(0, 1);

        Page<OrderMaster> result = repository.findByBuyerOpenid(OPENID, request);

        Assert.assertNotEquals(0, result.getTotalElements());
    }
}