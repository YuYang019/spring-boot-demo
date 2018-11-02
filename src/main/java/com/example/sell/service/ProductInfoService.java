package com.example.sell.service;

import com.example.sell.model.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductInfoService {

    ProductInfo findOne(String prodcutId);

    ProductInfo save(ProductInfo productInfo);

    // 查询上架所有
    List<ProductInfo> findUpAll();

    // 查询所有
    Page<ProductInfo> findAll(Pageable pageable);

    // 加库存

    // 减库存
}
