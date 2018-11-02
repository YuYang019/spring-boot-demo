package com.example.sell.service.impl;

import com.example.sell.model.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: maoyuyang
 * @Description:
 * @Date: 11:28 18/10/30
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoServiceImplTest {

    @Autowired
    private ProductInfoServiceImpl productService;

    @Test
    public void findAll() {
    }

    @Test
    public void findOne() {
        ProductInfo result = productService.findOne("abcd");
        Assert.assertEquals("abcd", result.getProductId());
    }

    @Test
    @Transactional
    public void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("12345");
        productInfo.setProductName("麻辣烫a");
        productInfo.setProductDescription("很好吃的啊");
        productInfo.setProductPrice(new BigDecimal(3.2));
        productInfo.setProductIcon("asdadasd");
        productInfo.setProductStock(100);
        productInfo.setProductStatus(1);
        productInfo.setCategoryType(12);

        ProductInfo result = productService.save(productInfo);

        Assert.assertNotNull(result);
    }

    @Test
    public void findUpAll() {
        List<ProductInfo> result = productService.findUpAll();

        Assert.assertNotEquals(0, result.size());
    }
}