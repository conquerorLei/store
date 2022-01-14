package com.lxl.store.service;

import com.lxl.store.entity.User;

public interface IUserService {
    /**
     * @author LiXianLei
     * @describtion 用户注册的接口
     * @return
     * @param user
     * @time 2022/1/12 19:42
     **/
    void register(User user);
    /**
     * @author LiXianLei
     * @describtion 用户登录的接口
     * @return {@link User} 将当前匹配的用户数据，如果没有就返回null值
     * @param username 用户名
     * @param password 用户密码
     * @time 2022/1/13 18:17
     **/
    User login(String username, String password);
    /**
     * @author LiXianLei
     * @describtion 更新用户密码
     * @return
     * @param uid 用户编号
     * @param username 用户名称
     * @param oldPassword 原密码
     * @param newPassword 新密码
     * @time 2022/1/14 11:21
     **/
    void changePassword(Integer uid, String username, String oldPassword, String newPassword);
}
