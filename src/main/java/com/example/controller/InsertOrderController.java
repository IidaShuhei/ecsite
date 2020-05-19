package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Order;
import com.example.form.OrderForm;
import com.example.service.InsertOrderService;

@RestController
@RequestMapping("/purchase")
public class InsertOrderController {

	@Autowired
	private InsertOrderService orderService;
	
	@CrossOrigin()
	@RequestMapping("")
	public List<Order> purchase(@RequestBody OrderForm orderForm) {
		
		return orderService.purchase(orderForm);
	}
}