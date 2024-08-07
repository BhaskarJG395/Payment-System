package com.cpt.payments.pojo;

import java.math.BigDecimal;
import java.sql.Timestamp;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Transaction {
	private int id;
	private int userId;
	private String paymentMethod;
	private int providerId;
	private int paumentTypeId;
	private int txnStatusId;
	private BigDecimal amount;
	private String currency;
	private String merchantTransactionReference;
	private String txnReference;
	private String providerReference;
	private String providerCode;
	private String providerMessage;
	private Timestamp crationDate;
	private Timestamp updateDate;
	private int retryCount;
}
