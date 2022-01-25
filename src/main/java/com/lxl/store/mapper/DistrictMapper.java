package com.lxl.store.mapper;

import com.lxl.store.entity.District;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DistrictMapper {
    /**
     * @author LiXianLei
     * @describtion 获取父编号的所有子地区信息
     * @return {@link List< District>} 子区间的所有信息
     * @param parent 父区间编号
     * @time 2022/1/25 11:26
     **/
    List<District> findDistrictByParent(String parent);

    /**
     * @author LiXianLei
     * @describtion 获取编号对应的名称
     * @return {@link String} 编号对应的名称
     * @param code 地区编号
     * @time 2022/1/25 11:41
     **/
    String findNameByCode(String code);
}
