package com.lxl.store.controller;

import com.lxl.store.entity.Address;
import com.lxl.store.service.IAddressService;
import com.lxl.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpSession;
import java.util.List;

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
    public JsonResult<Void> addNewAddress(Address address, @SessionAttribute("username") String username, @SessionAttribute("uid") Integer uid){
//        Integer uid = getUidFromSession(session);
//        String username = getUsernameFromSession(session);
        addressService.addNewAddress(uid, username, address);
        return new JsonResult<>(OK, "插入成功");
    }

    @RequestMapping({"", "/"})
    public JsonResult<List<Address>> getAddressByUid(HttpSession session){
        Integer uid = getUidFromSession(session);
        List<Address> data = addressService.getByUid(uid);
        return new JsonResult<>(OK, "获取地址成功", data);
    }
}
