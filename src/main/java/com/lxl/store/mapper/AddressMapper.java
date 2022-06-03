package com.lxl.store.mapper;

import com.lxl.store.entity.Address;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

@Mapper
public interface AddressMapper {

    /**
     * @author LiXianLei
     * @describtion 新增收货地址
     * @return {@link Integer} 影响的行数
     * @param address 收货地址
     * @time 2022/1/24 16:16
     **/
    Integer insert(Address address);

    /**
     * @author LiXianLei
     * @describtion 查询当前用户的地址数量
     * @return {@link Integer} 查询到的该用户的现有地址的数量
     * @param uid 用户id
     * @time 2022/1/24 16:17
     **/
    Integer countByUid(Integer uid);

    /**
     * @author LiXianLei
     * @describtion 根据用户id查询用户地址数据
     * @return {@link List<Address>}
     * @param uid 用户id
     * @time 2022/1/31 9:27
     **/
    List<Address> findByUid(Integer uid);

    /**
     * @author LiXianLei
     * @describtion 更新默认为非默认
     * @return {@link Integer} 影响的行数
     * @param uid 用户ID
     * @time 2022/6/2 22:45
     **/
    Integer updateDefaultToNormal(Integer uid);

    /**
     * @author LiXianLei
     * @describtion 根据地址ID设置默认地址
     * @return {@link Integer} 影响的行数
     * @param aid 地址ID
     * @param modifiedUser 修改人
     * @param modifiedTime 修改时间
     * @time 2022/6/2 22:49
     **/
    Integer updateDefaultByAid(Integer aid, String modifiedUser, Date modifiedTime);
}
