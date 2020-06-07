package com.example.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Order;
import com.example.service.ShowPurchaseHistroyService;

@RestController
@RequestMapping("/purchaseHistory")
public class ShowPurchaseHistoryController {
	
	@Autowired ShowPurchaseHistroyService showPurchaseHistoryService;
	
	@RequestMapping("")
	public List<Order> ShowPurchaseHistory(@RequestBody Map<String, Integer> param) {
		List<Order> purchaseHistory = showPurchaseHistoryService.findByUserIdAndStatus(param.get("userId"));
		System.out.println(param.get("userId"));
		System.out.println(purchaseHistory);
		return purchaseHistory;
	} 

}
