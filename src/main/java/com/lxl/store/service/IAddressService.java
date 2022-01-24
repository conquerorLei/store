package com.lxl.store.service;

import com.lxl.store.entity.Address;

/**
 * 地址服务层
 * @author LiXianLei
 */
public interface IAddressService {
    /**
     * @author LiXianLei
     * @describtion 用户添加地址
     * @param uid 用户id
     * @param username 用户名称
     * @param address 地址对象
     * @time 2022/1/24 17:20
     **/
    void addNewAddress(Integer uid, String username, Address address);
}
