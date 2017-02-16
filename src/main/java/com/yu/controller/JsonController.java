package com.yu.controller;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yu.domain.User;

@Controller
public class JsonController {
	@RequestMapping(value="/json", method={RequestMethod.GET})
	@ResponseBody
	public User json(@RequestParam("username") String username,
			@RequestParam("password") String password) {
		User user = new User();
		user.setUserName(username);
		user.setUserPassword(password);
		user.setUserId((new Random()).nextInt());
		return user;
	}
}
