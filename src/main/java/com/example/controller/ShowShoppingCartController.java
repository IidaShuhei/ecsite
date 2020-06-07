package com.example.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Order;
import com.example.domain.Status;
import com.example.service.ShowShoppingCartService;

@RestController
@RequestMapping("/showShoppingCart")
public class ShowShoppingCartController {

	@Autowired
	private ShowShoppingCartService showShoppingCartService;
	
	@RequestMapping("")
	public List<Order> showShoppingCart(@RequestBody Map<String, Integer> params) {
		int userId = params.get("userId");
		int status = Status.BEFORE.getStatusId();
		return showShoppingCartService.showShoppingCart(userId, status);
	}
}
