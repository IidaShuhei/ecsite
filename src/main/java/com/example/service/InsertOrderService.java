package com.example.service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.CreditCard;
import com.example.domain.Order;
import com.example.domain.PaymentMethod;
import com.example.domain.Status;
import com.example.form.OrderForm;
import com.example.mapper.OrderMapper;

@Service
@Transactional
public class InsertOrderService {

	@Autowired
	private OrderMapper orderMapper;
	
	public void purchase(OrderForm orderForm){
		
		int statusBefore = Status.BEFORE.getStatusId();
		int statusPaid = Status.PAID.getStatusId();
		
		int cash = PaymentMethod.CASH.getPaymentMethodId();
		int credit = PaymentMethod.CREDIT.getPaymentMethodId();
		
		int userId = orderForm.getUserId();
		
		List<Order> orderList = orderMapper.findByUserIdAndStatus(userId, statusBefore);
		
		Order order = orderList.get(0);
		order.setTotalPrice(orderForm.getTotalPrice());
		order.setDestinationName(orderForm.getDestinationName());
		order.setDestinationEmail(orderForm.getDestinationEmail());
		order.setDestinationZipcode(orderForm.getDestinationZipcode());
		order.setDestinationAddress(orderForm.getDestinationAddress());
		order.setDestinationTel(orderForm.getDestinationTel());
		
		
		order.setUserId(userId);
		order.setStatus(statusPaid);
		
		
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
		
		
		if(orderForm.getPaymentMethod() == cash) {
			order.setPaymentMethod(cash);
		} else if (orderForm.getPaymentMethod() == credit) {
			order.setPaymentMethod(credit);
			
			CreditCard creditCard = new CreditCard();
			creditCard.setCardNumber(orderForm.getCardNumber());
			creditCard.setCardExpYearAndMonth(orderForm.getCardExpYearAndMonth());
			creditCard.setCardName(orderForm.getCardName());
			creditCard.setCardCvv(orderForm.getCardCvv());
		}
		
		orderMapper.update(order);
		
	}
}
