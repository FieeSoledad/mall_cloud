package com.example.items.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Title: UserInterceptor.java
 * @Author: HSL
 * @Date: 2023/12/14 21:48
 * @Description:
 */
public class UserInterceptor implements HandlerInterceptor{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //1.获取用户信息
        String userInfo = request.getHeader("user-info");
        //2.判断是否获取了用户，若有，存入本地
        if(userInfo !=null && !userInfo.isEmpty())
        {
            UserContext.setUser(Long.valueOf(userInfo));
        }
        //3.放行
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //清理用户
        UserContext.removeUser();
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
