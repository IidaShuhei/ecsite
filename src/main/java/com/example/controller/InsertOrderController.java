package com.example.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.form.OrderForm;
import com.example.service.InsertOrderService;

@RestController
@RequestMapping("/purchase")
public class InsertOrderController {

	@Autowired
	private InsertOrderService orderService;
	
	@RequestMapping("")
	public void purchase(@RequestBody OrderForm orderForm) {
		orderService.purchase(orderForm);
	}
}