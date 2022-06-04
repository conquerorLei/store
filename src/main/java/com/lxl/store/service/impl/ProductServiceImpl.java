package com.lxl.store.service.impl;

import com.lxl.store.entity.Product;
import com.lxl.store.exception.ProductNotFoundException;
import com.lxl.store.mapper.ProductMapper;
import com.lxl.store.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LiXianLei
 * @since 2022/06/05 00:08
 */
@Service
public class ProductServiceImpl implements IProductService {

    private final ProductMapper productMapper;

    @Autowired
    private ProductServiceImpl(ProductMapper productMapper){
        this.productMapper = productMapper;
    }

    @Override
    public List<Product> findHotList() {
        List<Product> hotList = productMapper.getHotList();
        hotList.forEach(product -> {
            product.setPriority(null);
            product.setCreatedTime(null);
            product.setCreatedUser(null);
            product.setModifiedTime(null);
            product.setModifiedUser(null);
        });
        return hotList;
    }

    @Override
    public Product findById(Integer id) {
        Product product = productMapper.getById(id);
        if(product == null) throw new ProductNotFoundException("商品不存在");
        product.setModifiedUser(null);
        product.setModifiedTime(null);
        product.setCreatedUser(null);
        product.setCreatedTime(null);
        product.setPriority(null);
        product.setStatus(null);
        product.setId(null);
        product.setCategoryId(null);
        return product;
    }
}
