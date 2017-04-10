package com.yu.testng;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

/**
 * Web配置方式执行测试的脚手架
 */
@WebAppConfiguration(value="src/main/java")
@ContextHierarchy({
        @ContextConfiguration(name="parent", locations = "classpath*:application.xml"),
        @ContextConfiguration(name="child", locations = "classpath*:springmvc/spring-mvc.xml")
})
public class UserControllerTestWithWebConfig extends AbstractTestNGSpringContextTests {
    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;
    @BeforeClass
    public void setup() {
        System.out.println("wac: " + this.wac);
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();   //构造MockMvc
    }

    @Test
    protected void testUserController() throws Exception {
        ResultActions result = this.mockMvc.perform(MockMvcRequestBuilders.get("/"));
        System.out.println("user controller result: " + result);
        result.andExpect(MockMvcResultMatchers.view().name("index"))
                .andDo(MockMvcResultHandlers.print()) ;
    }

//    @Test(enabled=true)
//    protected void testJsonController() throws Exception {
//        this.mockMvc.perform(MockMvcRequestBuilders.get("/json?username=ykm&password=123"))
//                .andExpect(jsonPath("$.userName").value("ykm"))
//                .andExpect(jsonPath("$.userPassword").value("123"))
//                .andExpect(jsonPath("$.userId").exists())
//                .andDo(print());
//    }
//
//    @Test(enabled=true)
//    protected void testJsonController_params() throws Exception {
//        this.mockMvc.perform(MockMvcRequestBuilders.get("/json")
//                .param("username", "ykm").param("password", "123"))
//                .andExpect(jsonPath("$.userName").value("ykm"))
//                .andExpect(jsonPath("$.userPassword").value("123"))
//                .andExpect(jsonPath("$.userId").exists())
//                .andDo(print());
//    }

}
