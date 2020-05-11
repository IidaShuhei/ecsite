package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.User;
import com.example.mapper.UserMapper;

@Service
@Transactional
public class RegisterUserService {

	@Autowired
	private UserMapper userMapper;
	
	public User register(User user) {
		return userMapper.register(user);
	}
}
