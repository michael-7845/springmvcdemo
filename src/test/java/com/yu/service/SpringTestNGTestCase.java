package com.yu.service;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

/**
 * TestNG的测试脚手架
 */

//指定bean注入的配置文件
@ContextConfiguration(locations = { "classpath:application.xml" })
public class SpringTestNGTestCase extends AbstractTestNGSpringContextTests {

}