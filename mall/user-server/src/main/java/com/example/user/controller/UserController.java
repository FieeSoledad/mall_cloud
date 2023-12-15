package com.example.user.controller;

import com.example.user.domain.User;
import com.example.user.interceptor.UserContext;
import com.example.user.jwttools.JwtUtil;
import com.example.user.service.UserService;
import org.apache.http.HttpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseCookie;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Title: UserController.java
 * @Author: HSL
 * @Date: 2023/12/13 15:18
 * @Description:
 */
@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public Result selectUserById(@RequestParam(name="userid",defaultValue = "") int userid,@RequestHeader(value="truth",required = false) String truth,
                                 @RequestHeader(value="user-info",required = false) String user_info){

        System.out.println(truth); //统一过滤器添加的内容

        System.out.println(user_info); //请求头中装载ThreadLocal

        System.out.println(UserContext.getUser()); //拦截器保存信息为ThreadLocal


        User user = userService.selectUserById(userid);

        Integer code = user!=null? Code.SELECT_OK : Code.SELECT_ERR;

        String message = user!=null?"":"查询失败";

        return new Result(user,code,message);
    }

    @GetMapping("/all")
    public Result getAllUsers()
    {
        List<User> userList = userService.getAllUsers();

        Integer code = userList!=null? Code.SELECT_OK:Code.SELECT_ERR;

        String message = userList!=null?"":"查询失败";

        return new Result(userList,code,message);
    }

    @PutMapping
    public Result updatePassword(@RequestParam(name = "userid", defaultValue = "") int userid,
                                 @RequestParam(name = "password", defaultValue = "") String password) {
        boolean flag = userService.updatePassword(userid,password);

        return flag ? new Result(null,Code.UPDATE_OK,"修改成功"): new Result(null,Code.UPDATE_ERR,"修改失败");
    }

    @PostMapping("/login")
    public Result login(@RequestBody Map<String,String> requestBody, HttpServletResponse response){
        int userId = Integer.parseInt(requestBody.get("userId"));

        String password = requestBody.get("password");

        System.out.println(String.valueOf(userId)+password);

        User user = userService.selectUserById(userId);

        if(user!=null && password.equals(user.getPassword()))
        {
            String token = JwtUtil.generateToken(Long.valueOf(user.getUserid()));

            response.setHeader(HttpHeaders.AUTHORIZATION,token);

            response.setHeader("Access-Control-Expose-Headers","*");

            ResponseCookie cookie = ResponseCookie.from("Authorization", token).build();


            return new Result(null,Code.LOGIN_SUCCESS,"success");
        }else
        {
            return new Result(null, Code.USER_NOEXSIT,"failure");
        }
    }

    @GetMapping("/login")
    public Result login(@RequestParam(name="userId",defaultValue = "") int userId,
                        @RequestParam(name="password",defaultValue = "") String password,HttpServletResponse response){

        User user = userService.selectUserById(userId);

        if(user!=null && password.equals(user.getPassword()))
        {
            String token = JwtUtil.generateToken(Long.valueOf(user.getUserid()));

            response.setHeader(HttpHeaders.AUTHORIZATION,token);

            response.setHeader("Access-Control-Expose-Headers","authorization");

            return new Result(null,Code.LOGIN_SUCCESS,"success");
        }else
        {
            return new Result(null, Code.USER_NOEXSIT,"failure");
        }
    }
}
