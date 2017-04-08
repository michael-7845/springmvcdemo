package com.yu.testng;
 
import org.testng.Assert;
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.test.context.ContextConfiguration;  
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;  
import org.testng.annotations.AfterClass;  
import org.testng.annotations.BeforeClass;  
import org.testng.annotations.Test;

import com.yu.domain.User;
import com.yu.service.UserService;  

@ContextConfiguration(locations = { "classpath*:/application.xml" })  
public class SpringTestNG extends AbstractTestNGSpringContextTests {     
      
	@Autowired  
    private UserService userService; 
	
    @BeforeClass  
    public void setUp(){  
        System.out.println("setup()");  
    }  
      
    @Test(enabled=false)
    public void testOk() {    
        Assert.assertTrue(1 == 1);
    }  
    
	@Test(enabled=false)
    public void selectUserByIdTest(){  
		User user = userService.selectUserById(1);  
		System.out.println(user.getUserName() + ":" + user.getUserPassword());
		Assert.assertEquals("luoguohui", user.getUserName());
	} 
      
    @AfterClass  
    public void destroy() {  
        System.out.println("exit()");  
    }  
}  
