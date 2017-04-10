package com.yu.controller;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yu.domain.User;
import com.yu.service.UserService;

@Controller  
public class UserController {

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    @Resource
    private UserService userService; 

    @RequestMapping("/")    
    public ModelAndView getIndex(){      
        ModelAndView mav = new ModelAndView("index"); 
        User user = userService.selectUserById(1); 
        mav.addObject("user", user); 
        return mav; 
    }    
}  