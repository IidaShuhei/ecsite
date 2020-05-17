package com.example.domain;

import java.util.List;

import lombok.Data;

@Data
public class ItemForm {

	private List<Item> itemList;
	private List<Topping> toppingList;
}
