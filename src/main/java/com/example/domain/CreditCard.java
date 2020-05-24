package com.example.domain;

import lombok.Data;

@Data
public class CreditCard {

	private String cardNumber;
	private String cardExpYear;
	private String cardExpMonth;
	private String cardName;
	private String cardCvv;
}
