package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Order;
import com.example.domain.OrderItem;
import com.example.domain.OrderTopping;
import com.example.domain.Status;
import com.example.form.OrderItemForm;
import com.example.mapper.OrderItemMapper;
import com.example.mapper.OrderMapper;
import com.example.mapper.OrderToppingMapper;

@Service
@Transactional
public class AddItemService {
	
	@Autowired
	private OrderMapper orderMapper;

	@Autowired
	private OrderItemMapper orderItemMapper;
	
	@Autowired
	private OrderToppingMapper orderToppingMapper;
	
	
	//「商品をかごに追加」ボタンを押されたら発動するメソッド
	public Integer addItem(OrderItemForm orderItemForm) {
		
		Order order = null;
		int status = Status.BEFORE.getStatusId();
		int userId = orderItemForm.getUserId();
		
		List<Order> orderList = orderMapper.findByUserIdAndStatus(userId, status);
		
		Integer orderToppingId[] = orderItemForm.getOrderTopping();
		
		//もしuserIdとstatusが0のものがDBになければ新しい注文リストを作成
		if(orderList.isEmpty()) {
			//orderテーブルに挿入
			order = new Order();
			order.setUserId(userId);
			order.setStatus(status);
			order.setTotalPrice(0);
			orderMapper.purchase(order);
			
			//orderItemテーブルに挿入
			OrderItem orderItem = new OrderItem();
			orderItem.setItemId(orderItemForm.getItemId());
			orderItem.setOrderId(order.getId());
			orderItem.setQuantity(orderItemForm.getQuantity());
			orderItem.setSize(orderItemForm.getSize());
			orderItem.setSubTotal(orderItemForm.getSubTotal());
			orderItemMapper.insert(orderItem);
			
			//orderToppingテーブルに挿入（トッピングがあれば）
			OrderTopping orderTopping = new OrderTopping();
			if(orderToppingId != null) {
				orderTopping.setOrderItemId(orderItem.getId());
				for(Integer toppingId : orderToppingId) {
					orderTopping.setToppingId(toppingId);
					orderToppingMapper.insert(orderTopping);
				}
			}
			
			return orderItem.getId();
			
		} else {
			
			//もしorderがすでにあればorderListのものを取ってくる
			Order existOrder = orderList.get(0);
			
			//orderItemテーブルに挿入
			OrderItem orderItem = new OrderItem();
			orderItem.setItemId(orderItemForm.getItemId());
			orderItem.setOrderId(existOrder.getId());
			orderItem.setQuantity(orderItemForm.getQuantity());
			orderItem.setSize(orderItemForm.getSize());
			orderItem.setSubTotal(orderItemForm.getSubTotal());
			orderItemMapper.insert(orderItem);
			
			//orderToppingテーブルに挿入（トッピングがあれば）
			OrderTopping orderTopping = new OrderTopping();
			if(orderToppingId != null) {
				orderTopping.setOrderItemId(orderItem.getId());
				for(Integer toppingId : orderToppingId) {
					orderTopping.setToppingId(toppingId);
					orderToppingMapper.insert(orderTopping);
					
				}
			}
			
			return orderItem.getId();
			
		}
	}
	
}