package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.domain.Topping;

@Mapper
public interface ToppingMapper {

	public List<Topping> findAll();
}
