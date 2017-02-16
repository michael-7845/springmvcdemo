package com.yu.testng;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestDemo{
	private String s;
	
	@BeforeMethod
	public void init(){
		s="Hallo Welt!";
	}
	@Test
	public void testSayHello(){
		Assert.assertEquals(s,"Hallo Welt!");
	}
}