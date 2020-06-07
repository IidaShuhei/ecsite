package com.example.form;

import lombok.Data;

@Data
public class OrderItemForm {

	private Integer userId;
	private Integer itemId;
	private Integer quantity;
	private Character size;
	private Integer[] orderTopping;
	private Integer subTotal;

}