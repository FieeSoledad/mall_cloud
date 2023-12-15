package com.example.carts.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Controller;

/**
 * @Title: Cart.java
 * @Author: HSL
 * @Date: 2023/12/14 14:42
 * @Description:
 */
@Getter
@Setter
@ToString
@Controller
public class Cart {
    private String itemname;
    private int unitprice;
    private int amount;
}
