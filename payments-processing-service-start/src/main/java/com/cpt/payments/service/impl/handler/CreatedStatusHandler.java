package com.cpt.payments.service.impl.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cpt.payments.dao.interfaces.TransactionDao;
import com.cpt.payments.dto.TransactionDTO;
import com.cpt.payments.service.interfaces.PaymentStatusHandler;

@Component
public class CreatedStatusHandler extends PaymentStatusHandler {

	@Autowired
	private TransactionDao txnDao;
	
	@Override
	public String processStatus(TransactionDTO transactionDTO) {
		// TODO Auto-generated method stub
		
		String txnString = txnDao.createTransaction(transactionDTO);
		return "returning from CreatedStatusHandler \n"
				+"3_1. txnDao.createTransaction(transactionDTO) : "+txnString;
	}

}
