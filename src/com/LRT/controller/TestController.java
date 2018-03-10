package com.LRT.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.LRT.model.Userlogin;
import com.LRT.service.TestService;

@Controller
public class TestController {

	@Autowired
	private TestService service;

	@RequestMapping("test")
	private String test() {
		return "testjsp";
	}

	@RequestMapping("testinsert")
	public void testinsert(Userlogin userlogin) {
		Userlogin user = new Userlogin();
		user.setEmail("email insert");
		user.setPassword("password insert");
		service.serviceinsert(user);
	}

	@RequestMapping("testdelete")
	public void testdelete(Userlogin userlogin) {
		Userlogin user = new Userlogin();
		user.setEmail("email insert");
		user.setPassword("password insert");
		service.servicedelete(user);
	}

	@RequestMapping("testupdate")
	public void testupdate(Userlogin userlogin) {
		Userlogin user = new Userlogin();
		user.setEmail("email insert");
		user.setPassword("password insert");
		service.serviceupdate(user);
	}

}
