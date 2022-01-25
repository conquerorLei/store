package com.lxl.store.service;

import com.lxl.store.entity.District;

import java.util.List;

public interface IDistrictService {

    /**
     * @author LiXianLei
     * @describtion 通过父编号获取地区信息
     * @return {@link List<District>} 返回地区信息
     * @param parent 父编号
     * @time 2022/1/25 11:47
     **/
    List<District> getDistrictByParent(String parent);

    /**
     * @author LiXianLei
     * @describtion 获取地区编号对应的名称
     * @return {@link String} 返回地区编号对应的名称
     * @param code 地区编号
     * @time 2022/1/25 11:49
     **/
    String getNameByCode(String code);
}
