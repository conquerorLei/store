package com.lxl.store.mapper;

import com.lxl.store.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @author LiXianLei
 * @time 2022/01/12 00:07
 */
// @SpringBootTest标注当前的类是一个测试类，不会打包发送
@SpringBootTest
// @RunWith标注表示可以启用这个单元测试类，需要传递一个参数，必须是SpringRunner的实例类型
@RunWith(SpringRunner.class)
public class UserMapperTests {
    // 接口不可以直接创建一个接口对象的
    @Autowired
    private UserMapper userMapper;

    @Test
    public void insert(){
        User user = new User();
        user.setUsername("tim");
        user.setPassword("123456");
        Integer i = userMapper.insert(user);
        System.out.println(i);
    }

    @Test
    public void findByUsername(){
        String username = "tim";
        User user = userMapper.findByUsername(username);
        System.out.println(user);
    }

    @Test
    public void updatePassword(){
        String password = "123456";
//        Integer rows = userMapper.updatePassword(username, password);
        Date date = new Date();
        Integer rows = userMapper.updatePasswordByUid(1, password, "管理员", date);
        if(rows == 1) System.out.println("密码已经修改");
        else System.out.println("发生未知错误");
    }
    @Test
    public void findByUid(){
        User user = userMapper.findByUid(1);
        System.out.println(user);
    }
}
