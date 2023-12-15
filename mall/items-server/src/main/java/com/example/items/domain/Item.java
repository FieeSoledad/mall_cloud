package com.example.items.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Title: Item.java
 * @Author: HSL
 * @Date: 2023/12/13 15:42
 * @Description:
 */

@Getter
@Setter
@ToString
public class Item {
    private int itemid;
    private String itemname;
    private int price;
    private int stock;
    private String type;
}
