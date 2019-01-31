package com.etca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.ServletException;
import javax.validation.Valid;

import com.etca.model.User;
import com.etca.service.UserService;

@RequestMapping("/user")
@Controller
public class UserController {

    private static final Logger logger = 
        LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;
    
    @GetMapping("/")
    public String index(){
    	return "user/index";
    }
    
    @GetMapping("/login")
    public String login(){
    	return "user/login";
    }

    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("user", new User());
    	return "user/register";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute User newUser,
        BindingResult result, Model model, HttpServletRequest req)
    {
        if(result.hasErrors()){
            logger.info("Form errors");
            return "user/register";
        }

        User user = userService.register(newUser);

        if(user != null){
            logger.info("Registered user");
            model.addAttribute("user", user);

            try{
                req.login(user.getUsername(), user.getPassword());
            }catch(ServletException e){
                logger.error("ServletException: " + e.getMessage());
                // Redirect to the login page
                return "user/login";
            }

            return "redirect:/user/profile";

        }else{
            logger.info("User error occurred");
            return "user/register";
        }
    }

    @GetMapping("/profile")
    public String profile(@ModelAttribute("flash") String flash, Model model){

        if(flash != null){
            model.addAttribute("flash", flash);
        }
        
        return "user/profile";
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Page not found")
    public String handleException(Exception e, HttpServletRequest req){
        logger.info("\n\n"+ req.getRequestURL() + "\n\n");
        return "error";
    }
}
