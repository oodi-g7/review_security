package com.study.review_security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/joinForm")
    public String joinForm(){
        return "joinForm";
    }

    @PostMapping("/join")
    public String join(){
        return "redirect:/loginForm";
    }

    @GetMapping("/loginForm")
    public String loginForm(){
        return "loginForm";
    }

    @GetMapping("/loginSuccess")
    public String loginSuccess(){
        return "loginSuccess";
    }

    @GetMapping("/admin/dashboard")
    public String admin_dashboard(){
        return "admin/dashboard";
    }

    @GetMapping("/user/projectboard")
    public String user_projectboard(){
        return "user/projectboard";
    }
}
