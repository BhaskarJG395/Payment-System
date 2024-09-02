package com.cpt.payments.stripeprovider;

import java.util.List;

import com.cpt.payments.pojo.LineItem;

import lombok.Data;

@Data
public class CreatePaymentReq {
	private String txnRef;
	private String successUrl;
	private String cancelUrl;
	private List<LineItem> lineItem;
}