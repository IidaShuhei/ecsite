package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Item;
import com.example.service.ItemService;

@RestController
@RequestMapping("/item")
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@CrossOrigin()
	@RequestMapping("/showItems")
	public List<Item> findAll() {
		return itemService.findAll();
	}
}
