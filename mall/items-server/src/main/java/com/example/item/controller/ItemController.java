package com.example.item.controller;

import com.example.item.domain.Item;
import com.example.item.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Title: ItemController.java
 * @Author: HSL
 * @Date: 2023/12/13 15:44
 * @Description:
 */

@RestController
@RequestMapping("/item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping
    public Item selectUserById(@RequestParam(name="itemid",defaultValue = "1") int itemid){
        return itemService.selectItemById(itemid);
    }

    @GetMapping("/all")
    public Result getAllItems(HttpServletResponse response)
    {
        List<Item> itemList = itemService.getAllItems();

        return itemList!=null? new Result(itemList,Code.SELECT_OK,""):new Result(null,Code.SELECT_ERR,"查询失败");
    }

    @GetMapping("/type")
    public Result searchItemsByType(@RequestParam(name="type",defaultValue = "") String type)
    {
        List<Item> itemList = itemService.searchItemByType(type);

        return itemList!=null? new Result(itemList,Code.SELECT_OK,"查询成功"):new Result(null,Code.SELECT_ERR,"查询失败");
    }

    @GetMapping("/price")
    public Result searchItemsByType(@RequestParam(name="bottom",defaultValue = "0") int bottom,
                                    @RequestParam(name="top",defaultValue = "100000") int top)
    {
        List<Item> itemList = itemService.searchItemByPrice(bottom,top);

        return itemList!=null? new Result(itemList,Code.SELECT_OK,"查询成功"):new Result(null,Code.SELECT_ERR,"查询失败");
    }

    @PutMapping("/forsale")
    public Result insertItem(@RequestParam(name="itemname",defaultValue = "") String itemname,
                             @RequestParam(name="price",defaultValue = "0") int price,
                             @RequestParam(name="stock",defaultValue = "0") int stock,
                             @RequestParam(name="type",defaultValue = "") String type)
    {
        boolean flag = itemService.insertItem(itemname,price,stock,type);

        return flag? new Result(null,Code.INSERT_OK,"添加成功"):new Result(null,Code.INSERT_ERR,"添加失败");
    }



}
