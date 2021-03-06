package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.form.OrderItemForm;
import com.example.service.AddItemService;

@RestController
@RequestMapping("/add")
public class AddItemController {

	@Autowired
	private AddItemService addItemService;
	
	@RequestMapping("")
	public Integer AddItem(@RequestBody OrderItemForm orderItemForm) {
		
		return addItemService.addItem(orderItemForm);
	}
}
