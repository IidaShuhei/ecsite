package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Topping;
import com.example.mapper.ToppingMapper;

@Service
@Transactional
public class ToppingService {

	@Autowired
	private ToppingMapper toppingMapper;
	
	public List<Topping> findAll() {
		return toppingMapper.findAll();
	}
}
