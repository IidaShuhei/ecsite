package com.example.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.domain.LoginUser;
import com.example.domain.User;

@Mapper
public interface UserMapper {
	
	public LoginUser findByMail(String email);

	public User register(User user);
}
