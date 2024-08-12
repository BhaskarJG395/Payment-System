package com.cpt.payments.pojo;

import lombok.Data;

@Data
public class Payment {
	//email, name, amount ,currency, paymentMethod, paymentType, providerId (stripe/paypal/trustly)
	private int id;
	private int userId;

	private String paymentMehotd;
	private String provider;
	private String paymentType;
	private String txnStatus;
	

	private double amount;
	private String currency;
	
	private String merchantTransactionReference;
	private String txnReference;
	private String providerReference;
	private String providerCode;
	
}
