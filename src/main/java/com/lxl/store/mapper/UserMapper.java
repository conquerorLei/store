package com.lxl.store.mapper;

import com.lxl.store.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;

@Mapper
public interface UserMapper {
    /**
     * @param user
     * @return {@link Integer} 受影响的行数
     * @author LiXianLei
     * @describtion //TODO 插入用户的数据
     * @time 2022/1/11 23:19
     **/
    Integer insert(User user);

    /**
     * @param username
     * @return {@link User} 如果找到响应的用户则返回这个用户的数据，如果没有找到返回null
     * @author LiXianLei
     * @describtion //TODO 根据用户名来查询用户是否存在
     * @time 2022/1/11 23:21
     **/
    User findByUsername(String username);

    /**
     * @author LiXianLei
     * @describtion 修改密码
     * @return {@link Integer} 影响的行数
     * @param uid 用户编号
     * @param password 修改后的密码
     * @param modifiedUser 修改人
     * @param modifiedTime 修改时间
     * @time 2022/1/13 21:07
     **/
    Integer updatePasswordByUid(Integer uid, String password, String modifiedUser, Date modifiedTime);

    /**
     * @author LiXianLei
     * @describtion 根据用户id查询用户
     * @return {@link User} 用户
     * @param uid 用户编号
     * @time 2022/1/13 21:08
     **/
    User findByUid(Integer uid);
}
