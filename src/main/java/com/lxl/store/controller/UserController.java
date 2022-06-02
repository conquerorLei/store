package com.lxl.store.controller;

import com.lxl.store.entity.User;
import com.lxl.store.service.IUserService;
import com.lxl.store.util.FileUpload;
import com.lxl.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;

/**
 * @author LiXianLei
 * @time 2022/01/12 21:28
 */
//@Controller
@RestController // RestController = controller + ResponseBody
@RequestMapping("users")
public class UserController extends BaseController{

    private final IUserService userService;
    private final FileUpload fileUpload;

    @Autowired
    public UserController(IUserService userService, FileUpload fileUpload){
        this.userService = userService;
        this.fileUpload = fileUpload;
    }

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

    @RequestMapping("change_password")
    public JsonResult<Void> changePassword(String oldPassword, String newPassword, HttpSession session){
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        userService.changePassword(uid, username, oldPassword, newPassword);
        return new JsonResult<>(OK, "修改成功");
    }

    @RequestMapping("get_info")
    public JsonResult<User> getInfo(HttpSession session){
        Integer uid = getUidFromSession(session);
        User user = userService.getByUid(uid);
        return new JsonResult<>(OK, user);
    }

    @RequestMapping("change_info")
    public JsonResult<Void> changeInfo(HttpSession session, User user){
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        userService.changeInfo(uid, username, user);
        return new JsonResult<>(OK, "修改成功");
    }

    /**
     * @author LiXianLei
     * @describtion 对文件进行上传并返回文件在服务器存储的路径
     * @return {@link JsonResult<String>} 返回的数据应该包含上传文件的路径
     * @param session HttpSession
     * @param file 上传的文件类型
     * @time 2022/1/15 11:14
     **/
    @RequestMapping("change_avatar")
    public JsonResult<String> changeAvatar(HttpSession session, @RequestParam("file") MultipartFile file){
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        String avatar = fileUpload.fileUpload(file);
        userService.changeAvatar(uid, username, avatar);
        return new JsonResult<>(OK, "头像修改成功", avatar);
    }

}
