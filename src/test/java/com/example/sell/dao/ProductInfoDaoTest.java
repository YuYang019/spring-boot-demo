package com.example.sell.dao;

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

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoDaoTest {

    @Autowired
    private ProductInfoDao repository;

    @Test
    public void FindOneTest() {
        ProductInfo result = repository.findById("abcd").get();
        Assert.assertNotNull(result);
    }

    @Test
    @Transactional // 测试完回滚
    public void saveTest() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("12345");
        productInfo.setProductName("麻辣烫");
        productInfo.setProductDescription("很好吃的啊");
        productInfo.setProductPrice(new BigDecimal(3.2));
        productInfo.setProductIcon("asdadasd");
        productInfo.setProductStock(100);
        productInfo.setProductStatus(1);
        productInfo.setCategoryType(12);

        ProductInfo result = repository.save(productInfo);

        Assert.assertNotNull(result);
    }

    @Test
    public void updateTest() {
        ProductInfo productCategory = repository.findById("abcd").get();
        productCategory.setProductName("女生最爱");

        repository.save(productCategory);
    }

    @Test
    public void findByProductStatus() {
        List<ProductInfo> list = repository.findByProductStatus(0);
        Assert.assertNotEquals(0, list.size());
    }
}