package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Order;
import com.example.mapper.OrderMapper;

@Service
@Transactional
public class ShowShoppingCartService {

	@Autowired
	private OrderMapper orderMapper;
	
	public List<Order> showShoppingCart(Integer userId, Integer status) {
		return orderMapper.findByUserIdAndStatus(userId, status);
	}
}
