package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.domain.Order;
import com.example.domain.OrderItem;

@Mapper
public interface OrderMapper {

	public Integer purchase(Order order);
	
	public List<Order> findByUserId(Integer userId);
	
	public List<Order> findByUserIdAndStatus(Integer userId, Integer status);
	
	public void update(Order order);
	
	public List<OrderItem> count(Integer userId, Integer status);
}
