package com.example.sell.model;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * 产品类目
 */
@Entity
@DynamicUpdate // 动态更新
@Data  // lombok生成get set
public class ProductCategory {
    // 类目id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Integer categoryId;

    // 类目名
    @Column(name = "category_name")
    private String categoryName;

    // 类目编号
    @Column(name = "category_type")
    private Integer categoryType;

    @Override
    public String toString() {
        return categoryId + "," + categoryType + "," + categoryName;
    }
}
