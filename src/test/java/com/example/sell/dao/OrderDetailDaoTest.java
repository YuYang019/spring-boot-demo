package com.example.sell.dao;

import com.example.sell.model.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: maoyuyang
 * @Description:
 * @Date: 17:49 18/11/1
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailDaoTest {

    @Autowired
    private OrderDetailDao repository;

    @Test
    public void saveTest() {
        OrderDetail od = new OrderDetail();
        od.setDetailId("123");
        od.setOrderId("123456");
        od.setProductId("abcd");
        od.setProductName("女生最爱");
        od.setProductPrice(new BigDecimal(2.3));
        od.setProductIcon("eqweqe");
        od.setProductQuantity(10);

        OrderDetail result = repository.save(od);

        Assert.assertNotNull(result);
    }

    @Test
    public void findByOrderId() {
        List<OrderDetail> result = repository.findByOrderId("123456");

        Assert.assertNotEquals(0, result.size());
    }
}