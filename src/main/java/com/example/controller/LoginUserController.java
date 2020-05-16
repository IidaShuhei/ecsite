package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.User;
import com.example.form.LoginForm;
import com.example.service.LoginUserService;

@RestController
@RequestMapping("/login")
public class LoginUserController {
	
	@Autowired
	private LoginUserService loginUserService;
    
	@CrossOrigin()
	@RequestMapping("/findAllByMail")
	public User findAllByMail(@RequestBody LoginForm loginForm) {
		System.out.println(loginForm.getEmail());
		return loginUserService.findAllByMail(loginForm.getEmail());
	}
}