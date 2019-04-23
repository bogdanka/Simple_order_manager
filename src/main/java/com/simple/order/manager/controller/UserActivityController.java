package com.simple.order.manager.controller;

import com.simple.order.manager.pojo.OrderPOJO;
import com.simple.order.manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserActivityController {

    @Autowired
    private UserService userService;


    @GetMapping
    public String getuserPage(Model model) {
        List<OrderPOJO> listOrders = userService.getAllRecordsByUserId();

        model.addAttribute("list", listOrders);
        return "user";
    }

    @PostMapping
    public String saveNewRequest(@ModelAttribute OrderPOJO newOrder, Model model) {
        List<OrderPOJO> listorders = userService.saveNewRequest(newOrder);
        if (!listorders.isEmpty())
            model.addAttribute("list", listorders);
        return "user";
    }


}
