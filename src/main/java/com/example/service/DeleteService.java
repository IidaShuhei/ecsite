package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.mapper.OrderItemMapper;
import com.example.mapper.OrderToppingMapper;

@Service
@Transactional
public class DeleteService {

	@Autowired
	private OrderItemMapper orderItemMapper;
	
	@Autowired
	private OrderToppingMapper orderToppingMapper;
	
	public void delete(Integer id) {
		
		orderItemMapper.delete(id);
		orderToppingMapper.delete(id);
	}
}
