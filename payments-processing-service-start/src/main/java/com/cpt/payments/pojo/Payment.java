package com.cpt.payments.pojo;

import lombok.Data;

@Data
public class Payment {
	//email, name, amount ,currency, paymentMethod, paymentType, providerId (stripe/paypal/trustly)
	private String email;
	private String name;
	private double amount;
	private String currency;
	private String paymentMethod;
	private String paymentType;
	private String providerId;
}
