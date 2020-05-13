package com.example.service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Order;
import com.example.form.OrderForm;
import com.example.mapper.OrderMapper;

@Service
@Transactional
public class OrderService {

	@Autowired
	private OrderMapper orderMapper;
	
	public List<Order> purchase(OrderForm orderForm){
		
		Order order = new Order();
		order.setTotalPrice(orderForm.getTotalPrice());
		order.setDestinationName(orderForm.getDestinationName());
		order.setDestinationEmail(orderForm.getDestinationEmail());
		order.setDestinationZipcode(orderForm.getDestinationZipcode());
		order.setDestinationAddress(orderForm.getDestinationAddress());
		order.setDestinationTel(orderForm.getDestinationTel());
		
		
		Date date = new Date();
		order.setOrderDate(date);
		
		
		String deliveryDateTime = orderForm.getDeliveryDate() + " " + orderForm.getDeliveryTime() + ":00:00";
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date orderedDate = null;
			try {
				orderedDate = format.parse(deliveryDateTime);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		Timestamp timeStamp = new Timestamp(orderedDate.getTime());
		order.setDeliveryTime(timeStamp);
		
		
		if(orderForm.getPaymentMethod() == 1) {
			order.setPaymentMethod(1);
		} else if (orderForm.getPaymentMethod() == 2) {
			order.setPaymentMethod(2);
		}
		
		
		orderMapper.purchase(order);
		
		
		List<Order> orderList = orderMapper.findByUserId(orderForm.getUserId());
		return orderList;
	}
}
