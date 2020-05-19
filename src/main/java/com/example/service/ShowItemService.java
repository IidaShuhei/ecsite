package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Item;
import com.example.mapper.ItemMapper;
import com.example.mapper.ToppingMapper;

@Service
@Transactional
public class ShowItemService {

	@Autowired
	private ItemMapper itemMapper;
	
	@Autowired
	private ToppingMapper toppingMapper;
	
	public List<Item> findAll() {
		
		List<Item> itemList = itemMapper.findAll();
		
		for(Item item : itemList) {
			item.setToppingList(toppingMapper.findAll());
		}
		
		return itemList;
	}
}