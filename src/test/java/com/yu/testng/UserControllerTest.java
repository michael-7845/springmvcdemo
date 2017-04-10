package com.yu.testng;

import com.yu.controller.UserController;
import com.yu.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
/**
 * Created by Administrator on 2017/4/10.
 */
public class UserControllerTest {
    private MockMvc mockMvc;
    @BeforeClass
    public void setUp() {
        UserController userController = new UserController();
        ApplicationContext ctx =new ClassPathXmlApplicationContext("application.xml");
        userController.setUserService((UserService) ctx.getBean("userServiceImpl"));

        System.out.println("set up: " + userController);
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    protected void testUserController() throws Exception {
//        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();

        ResultActions result = this.mockMvc.perform(get("/"));
        System.out.println("user controller result: " + result);
        result.andExpect(view().name("index"));
    }

}
