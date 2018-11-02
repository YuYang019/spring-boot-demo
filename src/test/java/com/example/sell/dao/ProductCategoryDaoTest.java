package com.example.sell.dao;

import com.example.sell.model.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryDaoTest {

    @Autowired
    private ProductCategoryDao repository;

    @Test
    public void FindOneTest() {
        ProductCategory productCategory = repository.findById(1).get();
        System.out.println(productCategory.toString());
    }

    @Test
    @Transactional // 测试完回滚
    public void saveTest() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("sadqwha");
        productCategory.setCategoryType(12);

        ProductCategory result = repository.save(productCategory);

        Assert.assertNotNull(result);
    }

    @Test
    public void updateTest() {
        ProductCategory productCategory = repository.findById(1).get();
        productCategory.setCategoryName("女生最爱");

        repository.save(productCategory);
    }

    @Test
    public void findByCategoryTypeInTest() {
        List<Integer> list = Arrays.asList(2, 0, 3);

        List<ProductCategory> result = repository.findByCategoryTypeIn(list);

        Assert.assertNotEquals(0, result.size());
    }
}