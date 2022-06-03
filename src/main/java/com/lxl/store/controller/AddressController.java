package com.lxl.store.controller;

import com.lxl.store.entity.Address;
import com.lxl.store.service.IAddressService;
import com.lxl.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    /**
     * @author LiXianLei
     * @describtion 使用Restful格式编写请求
     * @return {@link JsonResult< Void>} JsonResult
     * @param aid 地址ID
     * @param session HttpSession
     * @time 2022/6/2 23:49
     **/
    @RequestMapping("set_default_address/{aid}")
    public JsonResult<Void> setDefaultAddress(@PathVariable("aid") Integer aid, HttpSession session){
        addressService.setDefault(aid,
                getUidFromSession(session),
                getUsernameFromSession(session));
        return new JsonResult<>(OK, "设置默认地址成功");
    }

    @RequestMapping("delete")
    public JsonResult<Void> deleteAddress(Integer aid, HttpSession session){
        addressService.deleteDefault(
                aid,
                getUidFromSession(session),
                getUsernameFromSession(session)
        );
        return new JsonResult<>(OK, "删除地址成功");
    }
}
