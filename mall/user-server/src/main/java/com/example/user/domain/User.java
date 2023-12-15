package com.example.user.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Title: User.java
 * @Author: HSL
 * @Date: 2023/12/13 15:15
 * @Description:
 */
@Getter
@Setter
@ToString
public class User {
    private int userid;
    private String password;
    private String username;
    private String gender;
    private String level;
}
