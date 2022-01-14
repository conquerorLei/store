package com.lxl.store.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户的实体类：SpringBoot约定大于配置
 * @author LiXianLei
 * @time 2022/01/11 23:03
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity {
    // 推荐使用包装类，方便在后期调用包装类已经实现的方法
    private Integer uid;
    private String username;
    private String password;
    private String salt; // 盐值，密码加密方面
    private String phone;
    private String email;
    private Integer gender;
    private String avatar; // 头像
    private Integer isDelete;
}
