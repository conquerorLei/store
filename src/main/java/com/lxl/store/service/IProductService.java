package com.lxl.store.service;

import com.lxl.store.entity.Product;

import java.util.List;

/**
 * @author LiXianLei
 * @since 2022/06/05 00:07
 */
public interface IProductService {

    /**
     * @author LiXianLei
     * @describtion 获取热点商品
     * @return {@link List<Product>} 热点商品
     * @time 2022/6/5 0:14
     **/
    List<Product> findHotList();

    /**
     * @author LiXianLei
     * @describtion 根据id获取商品
     * @return {@link Product} 商品列表
     * @param id 商品id
     * @time 2022/6/5 0:56
     **/
    Product findById(Integer id);

}
