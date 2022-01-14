package com.lxl.store.entity;

import lombok.Data;

import java.util.Date;

/**
 * 实体类的基类
 * @author LiXianLei
 * @time 2022/01/11 22:53
 */
@Data
public class BaseEntity {
    private String createdUser;
    private Date createdTime;
    private String modifiedUser;
    private Date modifiedTime;
}
