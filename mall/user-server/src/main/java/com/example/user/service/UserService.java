package com.example.user.service;

import com.example.user.domain.User;

import java.util.List;

/**
 * @Author: HSL
 * @Description:
 * @Version:
 **/

public interface UserService {
    User selectUserById(int userid);

    List<User> getAllUsers();

    boolean updatePassword(int userid,String password);
}
