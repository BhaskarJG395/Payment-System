package com.cpt.payments.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cpt.payments.pojo.Payment;
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
	public String processStatus(Payment payment) {
		// TODO Auto-generated method stub
		
		//systrace
		System.out.println("CreatedStatusHandler.processStatus() || payment "+payment);
		
		PaymentStatusHandler statusHandler = statusFactory.getStatusHandler("CREATED");
		
		String processStatusResponse = psh.processStatus(payment);
		
		return "Returning from PaymentServiceImpl class || statusHandler : "+statusHandler +" ||" + processStatusResponse ;
	}

	

}
