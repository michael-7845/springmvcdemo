package com.yu.service;

//import org.junit.Test;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.yu.domain.User;

/**
 * Service的测试样例
 */
//public class UserServiceTest extends SpringJUnit4TestCase {
public class UserServiceTest extends SpringTestNGTestCase {

    @Autowired  
    private UserService userService; 

    @Test
    public void selectUserByIdTest(){
        User user = userService.selectUserById(1);
        Assert.assertEquals("luoguohui", user.getUserName());
        Assert.assertEquals("123456", user.getUserPassword());
    }
}
