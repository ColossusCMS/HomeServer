package com.colossus.homeserver.controller;

import com.colossus.homeserver.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
    @GetMapping
    public String index() {
        return "/home";
    }

    @GetMapping("/login")
    public String login() {
        return "/login";
    }

}