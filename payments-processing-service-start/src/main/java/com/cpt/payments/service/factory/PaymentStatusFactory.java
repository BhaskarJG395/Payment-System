package com.cpt.payments.service.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.cpt.payments.constant.TransactionStatusEnum;
import com.cpt.payments.service.impl.handler.CreatedStatusHandler;
import com.cpt.payments.service.interfaces.PaymentStatusHandler;


@Component
public class PaymentStatusFactory {
	@Autowired
	private ApplicationContext ctx;
	
	@Autowired
	private CreatedStatusHandler createdStatusHandler;
	
	public PaymentStatusHandler getStatusHandler(TransactionStatusEnum statusEnum) {
	
		switch(statusEnum) 
		{
		case CREATED:
			CreatedStatusHandler createStatusHandler = ctx.getBean(CreatedStatusHandler.class);
			return createdStatusHandler;
		default:
			System.out.println("not valid input.");
			break;
		}
		
		
//		if(status.equals("CREATED") && status != null ) {
			//this line after introducing applicationContext		
//		}
		
		return null;
	}
}
