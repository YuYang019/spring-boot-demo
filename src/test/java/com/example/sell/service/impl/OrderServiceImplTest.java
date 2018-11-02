package com.example.sell.service.impl;

import com.example.sell.dto.CartDTO;
import com.example.sell.dto.OrderDTO;
import com.example.sell.model.OrderDetail;
import com.example.sell.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: maoyuyang
 * @Description:
 * @Date: 17:38 18/11/2
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {

    @Autowired
    private OrderServiceImpl orderService;

    private String OPEN_ID = "110110";

    @Test
    public void create() {

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerAddress("北京");
        orderDTO.setBuyerName("大师兄");
        orderDTO.setBuyerPhone("1241231231");
        orderDTO.setBuyerOpenid(OPEN_ID);

        // 购物车
        List<CartDTO> list = new ArrayList<>();

        CartDTO o1 = new CartDTO("12345", 1);
        list.add(o1);

        orderDTO.setCartDTOList(list);
        OrderDTO result = orderService.create(orderDTO);

        log.info("【创建订单】： result={}", result);
    }

    @Test
    public void findOne() {
    }

    @Test
    public void findList() {
    }

    @Test
    public void cancel() {
    }

    @Test
    public void finish() {
    }

    @Test
    public void paid() {
    }
}