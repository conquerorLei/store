package com.lxl.store.service.impl;

import com.lxl.store.entity.User;
import com.lxl.store.mapper.UserMapper;
import com.lxl.store.service.IUserService;
import com.lxl.store.exception.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.UUID;

/**
 * @author LiXianLei
 * @time 2022/01/12 19:42
 */
@Service // @Service注解：将当前类的对象交给Spring管理自动创建对象以及对象的维护
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void register(User user) {
        String username = user.getUsername();
        User res = userMapper.findByUsername(username);
        if(res != null){
            throw new UsernameDuplicatedException("用户名被占用");
        }

        // 需要进行密码加密处理：md5
        // 一般实现：(字符串 + password + 字符串) ---> md5进行加密，连续加载三次
        // 上述实现中的串就是盐值，盐值本身就是一个随机的字符串
        // 忽略密码强度提升了数据的安全性
        String password = user.getPassword();
        // 获取盐值：随机生成一个盐值
        String salt = UUID.randomUUID().toString().toUpperCase();
        // 将密码和盐值生成md5加密的密码
        String md5Password = getMD5Password(password, salt);
        // 将密码补全到user对象中
        user.setPassword(md5Password);
        // 盐值的记录
        user.setSalt(salt);
        // 数据补全：isDelete设置为0
        user.setIsDelete(0);
        // 数据补全：四个日志字段时间
        user.setCreatedUser(user.getUsername());
        user.setModifiedUser(user.getUsername());
        Date date = new Date();
        user.setCreatedTime(date);
        user.setModifiedTime(date);

        Integer rows = userMapper.insert(user);
        if(rows != 1){
            throw new InsertException("在用户插入的过程中产生了未知的异常");
        }
        System.out.println("OK");
    }

    @Override
    public User login(String username, String password) {
        // 根据用户名称查询用户的数据是否存在，如果不在则抛出异常
        User res = userMapper.findByUsername(username);
        if(res == null){
            throw new UsernameNotFoundException("用户数据不存在");
        }
        //检测用户的密码是否匹配
        // 获取数据库中的加密后的密码，将传进来的密码进行MD5加密。将加密结果与数据库中的密码进行匹配
        String oldMD5Password = res.getPassword();
        String salt = res.getSalt();
        String newMD5Password = getMD5Password(password, salt);
        if(!newMD5Password.equals(oldMD5Password)){
            throw new PasswordNotMatchException("密码错误");
        }
        // 判断is_delete是否为1
        if(res.getIsDelete() == 1){
            throw new UsernameNotFoundException("用户数据不存在");
        }
        // 调优：数据中转
        User user = new User();
        user.setUsername(res.getUsername());
        user.setUid(res.getUid());
        user.setAvatar(res.getAvatar());
        // 为了辅助其他页面做数据展示使用
        return user;
    }

    @Override
    public void changePassword(Integer uid, String username, String oldPassword, String newPassword) {
        User user = userMapper.findByUid(uid);
        if(user == null || user.getIsDelete() == 1){
            throw new UsernameNotFoundException("用户不存在");
        }
        String salt = user.getSalt();
        String oldMD5Password = getMD5Password(oldPassword, salt);
        if(!oldMD5Password.equals(user.getPassword())){
            throw new PasswordNotMatchException("原密码错误");
        }
        String newMD5Password = getMD5Password(newPassword, salt);
        int rows = userMapper.updatePasswordByUid(uid, newMD5Password,username, new Date());
        if(rows != 1){
            throw new UpdateException("更新时产生未知的异常");
        }
    }

    @Override
    public User getByUid(Integer uid) {
        User res = userMapper.findByUid(uid);
        if(res == null || res.getIsDelete() == 1){
            throw new UsernameNotFoundException("用户数据不存在");
        }
        User user = new User();
        user.setUsername(res.getUsername());
        user.setPhone(res.getPhone());
        user.setEmail(res.getEmail());
        user.setGender(res.getGender());
        return user;
    }

    @Override
    public void changeInfo(Integer uid, String username, User user) {
        User res = userMapper.findByUid(uid);
        if(res == null || res.getIsDelete() == 1){
            throw new UsernameNotFoundException("用户数据不存在");
        }
        user.setUid(uid);
        user.setModifiedUser(username);
        user.setModifiedTime(new Date());
        int rows = userMapper.updateInfoByUid(user);
        if(rows != 1){
            throw new UpdateException("更新时产生未知的异常");
        }
    }

    /**
     * @author LiXianLei
     * @describtion 加密算法
     * @return {@link String}
     * @param password
     * @param salt
     * @time 2022/1/13 18:24
     **/
    private String getMD5Password(String password, String salt){
        for(int i = 0; i < 3; i++) {
            password = DigestUtils.md5DigestAsHex((salt + password + salt).getBytes()).toUpperCase();
        }
        return password;
    }
}
