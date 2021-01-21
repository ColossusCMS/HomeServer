package com.colossus.homeserver.controller;

import com.colossus.homeserver.model.User;
import com.colossus.homeserver.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login() {
        return "account/login";
    }

    @PostMapping("/login")
    public String login(User user) {
        System.out.println("로그인");
        return "redirect:/";
    }

    @PostMapping("/register")
    public String register(User user) {
        userService.save(user);
        return "redirect:/";
    }

    @GetMapping("/register")
    public String register() {
        return "account/register";
    }
}
