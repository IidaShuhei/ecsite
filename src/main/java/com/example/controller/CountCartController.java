package com.example.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Status;
import com.example.service.CountCartService;

@RestController
public class CountCartController {

	@Autowired
	private CountCartService service;
	
	@RequestMapping("/count")
	public Integer count(@RequestBody Map<String, Integer> params) {
		System.out.println(params.get("userId"));
		System.out.println(Status.BEFORE.getStatusId());
		return service.count(params.get("userId"), Status.BEFORE.getStatusId());
	}
}
