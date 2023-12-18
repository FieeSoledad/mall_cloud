package com.example.user.dao;

import com.example.user.domain.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: HSL
 * @Description:
 * @Version:
 **/

@Repository
public interface UserDao {

    User selectUserById(int userid);

    List<User> getAllUsers();

    int updatePassword(@Param("userid")int userid,@Param("password") String password);  //这里为什么非得要？

    int insertUser(@Param("userId") int userId,@Param("password") String password);

    int updateLocation(@Param("userId") int userId,@Param("location") String location);

}
