package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.form.OrderItemForm;
import com.example.service.DeleteService;

@RestController
@RequestMapping("/delete")
public class DeleteItemController {

	@Autowired
	private DeleteService deleteService;
	
	@RequestMapping("")
	@CrossOrigin()
	public void delete(@RequestBody OrderItemForm orderItemForm) {
		
		deleteService.delete(orderItemForm.getItemId());
	}
}
