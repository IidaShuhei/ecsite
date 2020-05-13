package com.example.form;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.example.domain.OrderItem;

import lombok.Data;

@Data
public class OrderForm {

	private Integer userId;
	private Integer status;
	private Integer totalPrice;
	private Date orderDate;
	private String destinationName;
	private String destinationEmail;
	private String destinationZipcode;
	private String destinationAddress;
	private String destinationTel;
	private String deliveryDate;
	private Timestamp deliveryTime;
	private Integer paymentMethod;
	private List<OrderItem> orderItemList;
}
