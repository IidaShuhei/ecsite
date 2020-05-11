package com.example.domain;

import java.util.List;

import lombok.Data;

@Data
public class OrderItem {

	private Integer id;
	private Integer itemId;
	private Integer orderId;
	private Integer quantity;
	private Character size;
	private Item item;
	private List<OrderTopping> orderToppingList;
	
	public int getSubTotal() {
		
		int subTotalPrice = 0;
		int totalToppingPrice = 0;
		
		//商品サイズがMのとき
		if(size.equals('M')) {
			for(OrderTopping topping : orderToppingList) {
				totalToppingPrice += topping.getTopping().getPriceM();
			}
			subTotalPrice = (totalToppingPrice + item.getPriceM()) * quantity;
		}
		
		//商品サイズがLのとき
		if(size.equals('L')) {
			for(OrderTopping topping : orderToppingList) {
				totalToppingPrice += topping.getTopping().getPriceL();
			}
			subTotalPrice = (totalToppingPrice + item.getPriceL()) * quantity;
		}
		
		return subTotalPrice;
	}
}
