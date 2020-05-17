package com.example.form;

import java.util.List;

import lombok.Data;

@Data
public class OrderItemForm {

	private Integer itemId;
	private Integer quantity;
	private Character size;
	private List<Integer> orderToppingList;

}