package com.cpt.payments.entity;

import lombok.Data;
import lombok.Setter;

@Data
@Setter
public class TransactionEntity {
	
	private int id;
	private int userId;

	private int paymentMethodId;
	private int providerId;
	private int paymentTypeId;
	private int txnStatusId;
	

	private double amount;
	private String currency;
	
	private String merchantTransactionReference;
	private String txnReference;
	private String providerReference;
	private String providerCode;
}
