package com.example.controller;

import java.util.Map;

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
    
	
	@RequestMapping("/findAllByMail")
	public User findAllByMail(@RequestBody LoginForm loginForm) {
		return loginUserService.findAllByMail(loginForm.getEmail());
	}
	
	
	@RequestMapping("/findById")
	public User findById(@RequestBody Map<String, Integer> param) {
		return loginUserService.findById(param.get("userId"));
	}
}