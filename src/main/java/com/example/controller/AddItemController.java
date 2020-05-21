package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
	
	@CrossOrigin()
	@RequestMapping("")
	public Integer AddItem(@RequestBody OrderItemForm orderItemForm) {
		
		System.err.println("注文 : " + orderItemForm);
		
		return addItemService.addItem(orderItemForm);
	}
}
