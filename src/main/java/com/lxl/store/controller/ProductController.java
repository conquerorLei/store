package com.lxl.store.controller;

import com.lxl.store.entity.Product;
import com.lxl.store.service.IProductService;
import com.lxl.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author LiXianLei
 * @since 2022/06/05 00:24
 */
@RestController
@RequestMapping("products")
public class ProductController extends BaseController{

    private final IProductService productService;

    @GetMapping("get_hot_products")
    public JsonResult<List<Product>> getHotProducts(){
        List<Product> hotList = productService.findHotList();
        return new JsonResult<>(OK, "获取热点数据成功", hotList);
    }

    @GetMapping("get_product_by_id")
    public JsonResult<Product> getProductById(Integer id){
        Product product = productService.findById(id);
        return new JsonResult<>(OK, "获取商品成功", product);
    }

    @Autowired
    public ProductController(IProductService productService){
        this.productService = productService;
    }
}
