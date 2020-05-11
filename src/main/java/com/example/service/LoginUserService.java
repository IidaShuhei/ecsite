package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.LoginUser;
import com.example.mapper.UserMapper;

@Service
@Transactional
public class LoginUserService {

	@Autowired
	private UserMapper userMapper;
	
	public LoginUser findByMail(String email) {
		return userMapper.findByMail(email);
	}
}
