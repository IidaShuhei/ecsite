package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.User;
import com.example.form.RegisterUserForm;
import com.example.service.LoginUserService;
import com.example.service.RegisterUserService;

@RestController
@RequestMapping("/registerUserForm")
public class RegisterUserController {

	@Autowired
	private RegisterUserService registerUserService;
	
	@Autowired
	private LoginUserService loginUserService;
	
	@CrossOrigin
	@RequestMapping("/register")
	public User register(@RequestBody RegisterUserForm registerUserForm) {
		User user = new User();
		user.setName(registerUserForm.getName());
		user.setEmail(registerUserForm.getEmail());
		user.setZipcode(registerUserForm.getZipcode());
		user.setAddress(registerUserForm.getAddress());
		user.setTelephone(registerUserForm.getTelephone());
		System.out.println(user);
		registerUserService.register(user);
		
		return loginUserService.findAllByMail(user.getEmail());
		 
	}
	
	
}