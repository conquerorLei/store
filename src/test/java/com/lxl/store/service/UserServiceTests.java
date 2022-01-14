package com.lxl.store.service;

import com.lxl.store.entity.User;
import com.lxl.store.exception.InsertException;
import com.lxl.store.exception.UsernameDuplicatedException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author LiXianLei
 * @time 2022/01/12 20:13
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTests {
    @Autowired
    private IUserService userService;
    /**
     * @author LiXianLei
     * @describtion //TODO
     * @return
     * 测试注册
     * @time 2022/1/12 20:57
     **/
    @Test
    public void register(){
        try {
            User user = new User();
            user.setUsername("xx02");
            user.setPassword("123456");
            userService.register(user);
        }catch(UsernameDuplicatedException | InsertException e){
            System.out.println(e.getClass().getSimpleName() + e.getMessage());
        }
    }
    @Test
    public void login(){
        User user = userService.login("test01", "123");
        System.out.println(user);
    }
    @Test
    public void changePassword(){
        userService.changePassword(6, "管理员", "123", "321");
    }
    @Test
    public void getByUid(){
        User user = userService.getByUid(6);
        System.out.println(user);
    }
}
