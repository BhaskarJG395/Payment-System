package com.cpt.payments.utils;

import com.cpt.payments.constant.TransactionStatusEnum;

//public class TxnStatusEnumConverter implements Converter<String, Integer> {
public class TxnStatusEnumConverter {
	
	public Integer convert(String source) {
		return TransactionStatusEnum.getByName(source).getId();
	}
}
