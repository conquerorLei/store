package com.lxl.store.service;

import com.lxl.store.entity.Address;

import java.util.List;

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

    /**
     * @author LiXianLei
     * @describtion 获取指定用户的地址列表
     * @return {@link List<Address>} 地址列表
     * @param uid 用户id
     * @time 2022/1/31 9:35
     **/
    List<Address> getByUid(Integer uid);

    /**
     * @author LiXianLei
     * @describtion 设置默认地址
     * @param aid 地址ID
     * @param username 用户名
     * @time 2022/6/2 22:55
     **/
    void setDefault(Integer aid, Integer uid, String username);

    /**
     * @author LiXianLei
     * @describtion 删除地址
     * @param aid 地址ID
     * @param uid 用户ID
     * @param username 用户名
     * @time 2022/6/4 0:31
     **/
    void deleteDefault(Integer aid, Integer uid, String username);
}
