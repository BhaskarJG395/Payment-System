package com.cpt.payments.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cpt.payments.constant.TransactionStatusEnum;
import com.cpt.payments.pojo.Transaction;
import com.cpt.payments.service.factory.PaymentStatusFactory;
import com.cpt.payments.service.impl.handler.CreatedStatusHandler;
import com.cpt.payments.service.interfaces.PaymentStatusHandler;
import com.cpt.payments.service.interfaces.PaymentStatusService;



@Component
public class PaymentServiceImpl implements PaymentStatusService {
	@Autowired
	PaymentStatusFactory statusFactory ;
	
	@Autowired
	CreatedStatusHandler psh;

	@Override
	public String processStatus(Transaction transaction) {
		// TODO Auto-generated method stub
		
		//systrace
		System.out.println("CreatedStatusHandler.processStatus() || payment "+transaction);
		
		TransactionStatusEnum statusEnum = TransactionStatusEnum.getById(transaction.getTxnStatusId());
		
		PaymentStatusHandler statusHandler = statusFactory.getStatusHandler(statusEnum);
		String processStatusResponse = psh.processStatus(transaction);
		
		return "Returning from PaymentServiceImpl class \nstatusHandler : "+statusHandler +" ||" + processStatusResponse +"\ntransaction.getTxnStatusId():"+transaction.getTxnStatusId()+"\nstatusEnum : "+statusEnum;
	}
}
