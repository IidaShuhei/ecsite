package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Topping;
import com.example.service.ToppingService;

@RestController
@RequestMapping("/topping")
public class ToppingController {

	@Autowired
	private ToppingService toppingService;
	
	@RequestMapping("/show")
	@CrossOrigin()
	public List<Topping> findAll() {
		return toppingService.findAll();
	}
}
