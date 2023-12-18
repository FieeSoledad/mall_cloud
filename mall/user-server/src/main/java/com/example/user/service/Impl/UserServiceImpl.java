package com.example.user.service.Impl;

import com.example.user.dao.UserDao;
import com.example.user.domain.User;
import com.example.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Title: UserServiceImpl.java
 * @Author: HSL
 * @Date: 2023/12/13 15:20
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User selectUserById(int userid) {
        return userDao.selectUserById(userid);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public boolean updatePassword(int userid,String password) {
        return userDao.updatePassword(userid,password)!=0;//修改的行数大于一行就是True
    }

    @Override
    public boolean insertUser(int userId, String password) {
        return userDao.insertUser(userId,password)==1;
    }

    @Override
    public boolean updateLocation(int userId,String location) {
        return userDao.updateLocation(userId,location)==1;
    }
}
