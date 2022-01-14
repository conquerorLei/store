package com.lxl.store.controller;

import com.lxl.store.entity.User;
import com.lxl.store.service.IUserService;
import com.lxl.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author LiXianLei
 * @time 2022/01/12 21:28
 */
//@Controller
@RestController // RestController = controller + ResponseBody
@RequestMapping("users")
public class UserController extends BaseController{
    @Autowired
    private IUserService userService;

    @RequestMapping("register")
    public JsonResult<Void> register(User user){
        // 创建响应结果
//        JsonResult<Void> result = new JsonResult<>();
//        try{
//            userService.register(user);
//            result.setState(200);
//            result.setMessage("注册成功");
//        }catch(UsernameDuplicatedException e){
//            result.setState(4000);
//            result.setMessage("用户名被占用");
//        }catch(InsertException e){
//            result.setState(5000);
//            result.setMessage("注册时产生未知的异常");
//        }
        userService.register(user);
        return new JsonResult<>(OK);
    }

    @RequestMapping("login")
    public JsonResult<User> login(String username, String password, HttpSession session){
        User user = userService.login(username, password);
        session.setAttribute("uid", user.getUid());
        session.setAttribute("username", user.getUsername());
        return new JsonResult<>(OK, user);
    }
}