package com.cpt.payments.service.impl;

import org.springframework.stereotype.Component;

import com.cpt.payments.pojo.Payment;
import com.cpt.payments.service.factory.PaymentStatusFactory;
import com.cpt.payments.service.impl.handler.CreatedStatusHandler;
import com.cpt.payments.service.interfaces.PaymentStatusHandler;
import com.cpt.payments.service.interfaces.PaymentStatusService;



@Component
public class PaymentServiceImpl implements PaymentStatusService {

	@Override
	public String processStatus(Payment payment) {
		// TODO Auto-generated method stub
		
		//systrace
		System.out.println("CreatedStatusHandler.processStatus() || payment "+payment);
		
		PaymentStatusFactory statusFactory = new PaymentStatusFactory();
		PaymentStatusHandler statusHandler = statusFactory.getStatusHandler("CREATED");
		
		CreatedStatusHandler psh = new CreatedStatusHandler();
		String processStatusResponse = psh.processStatus(payment);
		
		return "Returning from PaymentServiceImpl class || statusHandler : "+statusHandler +" ||" + processStatusResponse ;
	}

	

}
