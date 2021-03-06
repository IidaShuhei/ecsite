package com.example.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.domain.OrderItem;

@Mapper
public interface OrderItemMapper {

	public Integer insert(OrderItem orderItem);
	
	public void delete(Integer id);
	
	public Integer count(Integer userId, Integer status);
}
