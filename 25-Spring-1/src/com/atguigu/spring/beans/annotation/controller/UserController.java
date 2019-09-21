package com.atguigu.spring.beans.annotation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.atguigu.spring.beans.annotation.service.UserService;

@Controller
public class UserController{
	//默认情况下必须要求依赖对象必须存在，如果要允许null值，可以设置它的required属性为false，例如：@Autowired(required=false)
	@Autowired
	private UserService userService;
	public void execute() {
		System.out.println("UserController execute...");
		userService.add();
	}

}
