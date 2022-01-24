package com.lxl.store.service;

import com.lxl.store.entity.Address;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author LiXianLei
 * @time 2022/01/24 17:39
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class AddressServiceTests {
    private IAddressService addressService;

    @Autowired
    public void setAddressService(IAddressService addressService){
        this.addressService = addressService;
    }

    @Test
    public void addNewAddress(){
        Address address = new Address();
        address.setPhone("17712341234");
        address.setName("女朋友");
        addressService.addNewAddress(2, "tim", address);
    }
}
