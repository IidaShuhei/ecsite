package com.example.domain;

public enum PaymentMethod {

	CASH(1,"代金引換"), CREDIT(2,"クレジットカード");
	
	private final Integer paymentMethodId;
	
	private final String paymentMethodName;
	
	private PaymentMethod(final Integer paymentMethodId, final String paymentMethodName) {
		this.paymentMethodId = paymentMethodId;
		this.paymentMethodName = paymentMethodName;
	}
	
	public Integer getPaymentMethodId() {
		return paymentMethodId;
	}
	
	public String getPaymentMethodName() {
		return paymentMethodName;
	}
}
