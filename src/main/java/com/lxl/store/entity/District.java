package com.lxl.store.entity;

import lombok.Data;

/**
 * 省市区信息实体类
 * @author LiXianLei
 * @time 2022/01/25 11:17
 */
@Data
public class District {
    private Integer id;
    private String parent;
    private String code;
    private String name;
}
