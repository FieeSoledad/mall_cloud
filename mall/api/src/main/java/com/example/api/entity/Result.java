package com.example.api.entity;

/**
 * @Title: Result.java
 * @Author: HSL
 * @Date: 2023/12/13 22:10
 * @Description:
 */
public class Result {
    public Object data;

    public Integer code;

    public String message;

    public Result(){}

    public Result(Object data, Integer code, String message) {
        this.data = data;
        this.code = code;
        this.message = message;
    }
}
