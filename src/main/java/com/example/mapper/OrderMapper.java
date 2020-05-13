package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.domain.Order;

@Mapper
public interface OrderMapper {

	public Integer purchase(Order order);
	
	public List<Order> findByUserId(Integer userId);
	
	public List<Order> findByUserIdAndStatus(Integer userId, Integer status);
}
