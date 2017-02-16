package com.yu.service;

import org.junit.Test;  
import org.springframework.beans.factory.annotation.Autowired;  
import com.yu.domain.User;
import com.yu.service.UserService;

public class UserServiceTest { //extends SpringTestCase {

    @Autowired  
    private UserService userService; 

//    @Test  
//    public void selectUserByIdTest(){  
//        User user = userService.selectUserById(1);  
//        System.out.println(user.getUserName() + ":" + user.getUserPassword());
//    }  
}
