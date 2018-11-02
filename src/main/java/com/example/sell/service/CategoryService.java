package com.example.sell.service;

import com.example.sell.model.ProductCategory;

import java.util.List;

public interface CategoryService {

    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryType);

    ProductCategory save(ProductCategory productCategory);
}
