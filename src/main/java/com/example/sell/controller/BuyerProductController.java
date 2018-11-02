package com.example.sell.controller;

import com.example.sell.model.ProductCategory;
import com.example.sell.model.ProductInfo;
import com.example.sell.service.CategoryService;
import com.example.sell.service.ProductInfoService;
import com.example.sell.service.VO.ProductInfoVO;
import com.example.sell.service.VO.ProductVO;
import com.example.sell.service.VO.ResultVO;
import com.example.sell.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: maoyuyang
 * @Description: 买家商品
 * @Date: 18:46 18/10/31
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductInfoService productInfoService;

    @Autowired
    private CategoryService categoryService;

    /**
     * 返回的数据格式
     * 最外层 -> ResultVO
     * data这层 -> List<ProductVO>
     * foods这层 -> List<ProductInfoVO>
     * <p>
     * {
     * code: 0,
     * msg: "成功",
     * data: [
     * {
     * name: "热榜",
     * type: 1,
     * foods: [
     * {
     * id: "123456",
     * name: "皮蛋粥",
     * price: 1.12,
     * description: "好吃",
     * icon: "http://www.icon.com"
     * }
     * ]
     * }
     * ]
     * }
     * <p>
     * 总体思路：先查所有上架商品，由上架商品找到上架的类目，再由类目开始构造数据格式
     */
    @GetMapping("/list")
    public ResultVO list() {
        // 1. 查询所有上架商品
        List<ProductInfo> productInfoList = productInfoService.findUpAll();

        // 2. 查询类目（一次性查询）
        // List<Integer> categoryTypeList = new ArrayList<>();
        // 传统方法获取type list
//        for (ProductInfo productInfo : productInfoList) {
//            categoryTypeList.add(productInfo.getCategoryType());
//        }
        // 精简(java8, lambda)
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(e -> e.getCategoryType())
                .collect(Collectors.toList());

        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

        // 3. 数据封装
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory : productCategoryList) {
            // 这里设置的是对应字段data里的值
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());

            // 设置data里foods的值
            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    // 工具方法，将info的值拷贝到vo里，这样不需要一个个设置了
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }

            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }

        return ResultVOUtil.success(productVOList);
    }
}
