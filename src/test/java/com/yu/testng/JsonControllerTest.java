package com.yu.testng;

import com.yu.controller.JsonController;
import com.yu.controller.UserController;
import com.yu.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

/**
 * Created by Administrator on 2017/4/10.
 */
public class JsonControllerTest {
    private MockMvc mockMvc;
    @BeforeClass
    public void setUp() {
        JsonController jsonController = new JsonController();
        System.out.println("set up: " + jsonController);
        mockMvc = MockMvcBuilders.standaloneSetup(jsonController).build();
    }

    @Test
    protected void testUserController() throws Exception {
//        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();

        ResultActions result = this.mockMvc.perform(get("/json?username=ykm&password=123"));
        System.out.println("user controller result: " + result);
        result.andExpect(jsonPath("$.userName").value("ykm"))
                .andExpect(jsonPath("$.userPassword").value("123"))
                .andExpect(jsonPath("$.userId").exists())
                .andDo(print());
    }

}
