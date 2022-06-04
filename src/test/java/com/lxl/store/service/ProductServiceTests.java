package com.lxl.store.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author LiXianLei
 * @since 2022/06/05 00:16
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductServiceTests {

    private IProductService productService;

    @Test
    public void findHotList(){
        productService.findHotList().forEach(System.out::println);
    }

    @Test
    public void findById(){
        System.out.println(productService.findById(10000017));
    }

    @Autowired
    public void setProductService(IProductService productService) {
        this.productService = productService;
    }
}
