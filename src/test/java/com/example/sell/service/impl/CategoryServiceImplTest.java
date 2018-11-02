package com.example.sell.service.impl;

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
public class CategoryServiceImplTest {

    @Autowired
    private CategoryServiceImpl categoryService;

    @Test
    public void findOne() {
        ProductCategory result = categoryService.findOne(1);
        Integer ID = 1;
        Assert.assertEquals(ID, result.getCategoryId());
    }

    @Test
    public void findAll() {
        List<ProductCategory> result = categoryService.findAll();
        Assert.assertNotEquals(0, result.size());
    }

    @Test
    public void findByCategoryTypeIn() {
        List<Integer> list = Arrays.asList(12, 10, 0);
        List<ProductCategory> result = categoryService.findByCategoryTypeIn(list);

        Assert.assertNotEquals(0, result.size());
    }

    @Test
    @Transactional
    public void save() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("谁都不爱");
        productCategory.setCategoryType(23);

        ProductCategory result = categoryService.save(productCategory);

        Assert.assertNotNull(result);
    }
}