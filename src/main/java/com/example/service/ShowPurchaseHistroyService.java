package com.example.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Order;
import com.example.mapper.OrderMapper;

@Service
@Transactional
public class ShowPurchaseHistroyService {
	
	@Autowired OrderMapper orderMapper;
	
	public List<Order> findByUserIdAndStatus(Integer userId) {
		return orderMapper.findByUserIdAndStatus(userId,2);
	}
}
