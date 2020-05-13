package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Order;
import com.example.form.OrderForm;
import com.example.service.OrderService;

@RestController
@RequestMapping("/purchase")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@RequestMapping("")
	public List<Order> purchase(@RequestBody OrderForm orderForm) {
		return orderService.purchase(orderForm);
	}
}
