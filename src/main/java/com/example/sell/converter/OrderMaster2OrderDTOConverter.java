package com.example.sell.converter;

import com.example.sell.dto.OrderDTO;
import com.example.sell.model.OrderMaster;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: maoyuyang
 * @Description:
 * @Date: 14:02 18/11/18
 */
public class OrderMaster2OrderDTOConverter {

    public static OrderDTO convert(OrderMaster orderMaster) {

        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster, orderDTO);

        return orderDTO;
    }

    public static List<OrderDTO> convert(List<OrderMaster> orderMasterList) {

        return orderMasterList
                .stream()
                .map(e -> convert(e))
                .collect(Collectors.toList());
    }
}
