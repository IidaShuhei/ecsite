package com.example.form;

import lombok.Data;

@Data
public class RegisterUserForm {

	private String name;
	private String email;
	private String zipcode;
	private String address;
	private String telephone;
//	private String confirmationPassword;
}
