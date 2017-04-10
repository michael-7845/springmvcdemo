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
 * 独立方式执行mvc测试的脚手架
 */
public class UserControllerTest {
    private MockMvc mockMvc;

    @BeforeClass
    public void setUp() {
        UserController userController = new UserController();
        ApplicationContext ctx =new ClassPathXmlApplicationContext("application.xml");
        userController.setUserService((UserService) ctx.getBean("userServiceImpl"));
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    protected void testUserController() throws Exception {
        ResultActions result = this.mockMvc.perform(get("/"));
        System.out.println("user controller result: " + result);
        result.andExpect(view().name("index"));
    }

}
