package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Order;
import com.example.service.ShowShoppingCartService;

@RestController
@RequestMapping("/showShoppingCart")
public class ShowShoppingCartController {

	@Autowired
	private ShowShoppingCartService showShoppingCartService;
	
	@RequestMapping("")
	public List<Order> showShoppingCart() {
		return showShoppingCartService.showShoppingCart(1, 0);
	}
}
