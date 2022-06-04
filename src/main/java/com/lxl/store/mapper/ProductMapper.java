package com.lxl.store.mapper;

import com.lxl.store.entity.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author LiXianLei
 * @since 2022/06/04 20:44
 */
@Mapper
public interface ProductMapper {

    /**
     * @author LiXianLei
     * @describtion 获取热点商品列表
     * @return {@link List<Product>} 商品列表
     * @time 2022/6/5 0:14
     **/
    List<Product> getHotList();

    /**
     * @author LiXianLei
     * @describtion 根据id获取商品
     * @return {@link Product} 商品
     * @param id 商品id
     * @time 2022/6/5 0:50
     **/
    Product getById(Integer id);

}
