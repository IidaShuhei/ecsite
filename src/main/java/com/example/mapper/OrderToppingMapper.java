package com.example.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.domain.OrderTopping;

@Mapper
public interface OrderToppingMapper {

	public void insert(OrderTopping orderTopping);
}
