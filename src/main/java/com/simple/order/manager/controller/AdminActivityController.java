package com.simple.order.manager.controller;

import com.simple.order.manager.model.Status;
import com.simple.order.manager.pojo.OrderPOJO;
import com.simple.order.manager.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminActivityController {

    @Autowired
    private AdminService adminService;


    @GetMapping
    public String getAdminPage(Model model) {
        List<OrderPOJO> currentRecords = adminService.getAllCurrentRecords();
        model.addAttribute("list", currentRecords);
        model.addAttribute("title", "Активные записи");
        return "admin";
    }

    @GetMapping("/completed")
    public String getListCompletedOrders(Model model) {
        List<OrderPOJO> currentRecords = adminService.getAllCurrentRecordsByStatus(Status.COMPLETED);
        model.addAttribute("list", currentRecords);
        model.addAttribute("current_title", "Выполненные запросы");
        return "closed";
    }

    @GetMapping("/rejected")
    public String getListRejectedOrders(Model model) {
        List<OrderPOJO> currentRecords = adminService.getAllCurrentRecordsByStatus(Status.REJECTED);
        model.addAttribute("list", currentRecords);
        model.addAttribute("current_title", "Отказанные запросы");
        return "closed";
    }

    @GetMapping("/complete/{id}")
    public String completeOrderById(@PathVariable("id") Long id, Model model) {
        List<OrderPOJO> currentRecords = adminService.completeOrderById(id);
        model.addAttribute("list", currentRecords);
        return "admin";
    }

    @GetMapping("/reject/{id}")
    public String rejectOrderById(@PathVariable("id") Long id, Model model) {
        List<OrderPOJO> currentRecords = adminService.rejectOrderById(id);
        model.addAttribute("list", currentRecords);
        return "admin";
    }


}
