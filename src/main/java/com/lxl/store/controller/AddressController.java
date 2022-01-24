package com.lxl.store.controller;

import com.lxl.store.entity.Address;
import com.lxl.store.service.IAddressService;
import com.lxl.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author LiXianLei
 * @time 2022/01/24 17:47
 */
@RestController
@RequestMapping("addresses")
public class AddressController extends BaseController{
    private final IAddressService addressService;
    @Autowired
    public AddressController(IAddressService addressService){
        this.addressService = addressService;
    }

    @RequestMapping("add_new_address")
    public JsonResult<Void> addNewAddress(Address address, HttpSession session){
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        addressService.addNewAddress(uid, username, address);
        return new JsonResult<>(OK, "插入成功");
    }
}
