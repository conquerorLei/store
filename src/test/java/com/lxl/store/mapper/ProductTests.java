package com.lxl.store.mapper;

import com.lxl.store.entity.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author LiXianLei
 * @since 2022/06/05 00:03
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductTests {

    private ProductMapper productMapper;

    @Test
    public void getHotList(){
        List<Product> hotList = productMapper.getHotList();
        hotList.forEach(System.out::println);
    }

    @Test
    public void getById(){
        System.out.println(productMapper.getById(10000017));
    }

    @Autowired
    public void setProductMapper(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }
}
