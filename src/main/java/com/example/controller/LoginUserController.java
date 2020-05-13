package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.LoginUser;
import com.example.form.LoginForm;
import com.example.service.LoginUserService;

@RestController
@RequestMapping("/login")
public class LoginUserController {
	
	@Autowired
	private LoginUserService loginUserService;

	@RequestMapping("/findByMail")
	public LoginUser findByMail(@RequestBody LoginForm loginForm) {
		return loginUserService.findByMail(loginForm.getEmail());
	}
}