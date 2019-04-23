package com.simple.order.manager.controller;


import com.simple.order.manager.model.AppUserPrincipal;
import com.simple.order.manager.model.Role;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefaultSuccessController {


    @GetMapping("/filter")
    public String filterDirectedUrl() {
        AppUserPrincipal principal = (AppUserPrincipal) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        if (principal.getRole() == Role.ROLE_USER) {
            return "redirect:/user/";
        } else if (principal.getRole() == Role.ROLE_ADMIN) {
            return "redirect:/admin/";
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping(value = {"/", "/login"})
    public String showWelcomePage() {
        return "login";
    }


}
