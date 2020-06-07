package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.mapper.OrderMapper;

@Service
@Transactional
public class CountCartService {

	@Autowired
	private OrderMapper mapper;
	
	public Integer count(Integer userId, Integer status) {
		return mapper.count(userId, status);
	}
	
}
