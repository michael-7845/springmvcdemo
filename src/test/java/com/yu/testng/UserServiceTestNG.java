package com.yu.testng;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
//import com.yu.domain.User;
//import com.yu.service.UserService;
import org.testng.annotations.BeforeClass;

@ContextConfiguration(locations = { "classpath*:/application.xml" })  
public class UserServiceTestNG extends AbstractTestNGSpringContextTests {
//	@Autowired  
//    private UserService userService; 
	
	@BeforeClass  
    public void setUp(){  
        System.out.println("初始化");  
    } 
	
	@Test
	public void testSomething() {
		Assert.assertEquals(1,1);
	}
	
//	@Test  
//    public void selectUserByIdTest(){  
//        User user = userService.selectUserById(1);  
//        System.out.println(user.getUserName() + ":" + user.getUserPassword());
//        Assert.assertEquals(1,1);
//    }  
}  
