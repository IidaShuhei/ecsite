package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.User;
import com.example.mapper.UserMapper;

@Service
@Transactional
public class LoginUserService {

	@Autowired
	private UserMapper userMapper;
	
	public User findAllByMail(String email) {
		return userMapper.findAllByMail(email);
	}
	
	public User findById(Integer id) {
		return userMapper.findById(id);
	}
}
