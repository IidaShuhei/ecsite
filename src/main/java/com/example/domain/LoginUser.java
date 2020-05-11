package com.example.domain;

import java.util.List;

import lombok.Data;

@Data
public class LoginUser {

	private Integer id;
	private String name;
	private String email;
	private String password;
	private String zipcode;
	private String address;
	private String telephone;
	private List<Order> orderList;
}
