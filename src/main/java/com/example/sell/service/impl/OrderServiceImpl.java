package com.example.sell.service.impl;

import com.example.sell.dao.OrderDetailDao;
import com.example.sell.dao.OrderMasterDao;
import com.example.sell.dto.CartDTO;
import com.example.sell.dto.OrderDTO;
import com.example.sell.enums.OrderStatusEnum;
import com.example.sell.enums.PayStatusEnum;
import com.example.sell.enums.ResultEnum;
import com.example.sell.exception.SellException;
import com.example.sell.model.OrderDetail;
import com.example.sell.model.OrderMaster;
import com.example.sell.model.ProductInfo;
import com.example.sell.service.OrderService;
import com.example.sell.service.ProductInfoService;
import com.example.sell.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: maoyuyang
 * @Description: 订单service实现类
 * @Date: 18:19 18/11/1
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductInfoServiceImpl productService;

    @Autowired
    private OrderMasterDao orderMasterDao;

    @Autowired
    private OrderDetailDao orderDetailDao;

    @Override
    @Transactional
    public OrderDTO create(OrderDTO orderDTO) {

        String orderId = KeyUtil.getUniqueKey();
        BigDecimal orderAmount = new BigDecimal(0);

        // 1. 查询商品数量，价格等信息。
        for (CartDTO cartDTO : orderDTO.getCartDTOList()) {
            // 判断该商品是否存在
            ProductInfo productInfo = productService.findOne(cartDTO.getProductId());
            if (productInfo == null) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }

            // 2. 计算总价
            orderAmount = productInfo.getProductPrice()
                    .multiply(new BigDecimal(cartDTO.getProductQuantity()))
                    .add(orderAmount);

            // 3. 写入订单数据库（orderDetail)
            OrderDetail orderDetail = new OrderDetail();
            // 先拷贝属性，再设置
            BeanUtils.copyProperties(productInfo, orderDetail);
            // 多设置一个订购数量，因为productInfo里没有数量
            orderDetail.setProductQuantity(cartDTO.getProductQuantity());
            orderDetail.setDetailId(KeyUtil.getUniqueKey());
            orderDetail.setOrderId(orderId);

            orderDetailDao.save(orderDetail);
        };

        // 写入orderMaster
        OrderMaster orderMaster = new OrderMaster();
        // 先拷贝属性，再设置
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMaster.setOrderId(orderId);
        orderMaster.setOrderAmount(orderAmount);
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());

        orderMasterDao.save(orderMaster);

        // 4. 扣库存
//        List<CartDTO> cartDTOList = new ArrayList<>();
//        orderDTO.getOrderDetailList()
//                .stream()
//                .map(e -> new CartDTO(e.getProductId(), e.getProductQuantity()))
//                .collect(Collectors.toList());
        productService.decreaseStock(orderDTO.getCartDTOList());

        return orderDTO;
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
