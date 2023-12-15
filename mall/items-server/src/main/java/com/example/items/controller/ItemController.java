package com.example.items.controller;

import com.example.items.domain.Item;
import com.example.items.service.ItemService;
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
@CrossOrigin
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
        response.setHeader("Access-Contorll-Expose-Origin","authorization");

        List<Item> itemList = itemService.getAllItems();

        return itemList!=null? new Result(itemList,Code.SELECT_OK,""):new Result(null,Code.SELECT_ERR,"查询失败");
    }
}
