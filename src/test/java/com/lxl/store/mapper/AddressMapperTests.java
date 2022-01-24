package com.lxl.store.mapper;

import com.lxl.store.entity.Address;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author LiXianLei
 * @time 2022/01/24 16:44
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class AddressMapperTests {
    private AddressMapper addressMapper;

    @Autowired
    public void setAddressMapper(AddressMapper addressMapper){
        this.addressMapper = addressMapper;
    }

    @Test
    public void insert(){
        Address address = new Address();
        address.setUid(1);
        address.setPhone("17712341234");
        address.setName("女朋友");
        addressMapper.insert(address);
    }

    @Test
    public void countByUid(){
        Integer count = addressMapper.countByUid(1);
        System.out.println(count);
    }
}
