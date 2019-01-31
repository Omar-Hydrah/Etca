package com.etca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequestMapping("/")
@Controller
public class HomeController {
    
    @GetMapping({ "/", "/index","/home"})
    public String index(){
    	return "home";
    }

    @GetMapping("/login")
    public String login(){
    	return "redirect:/user/login";
    }
}
