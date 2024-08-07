package com.cpt.payments.service.impl.handler;

import org.springframework.stereotype.Component;
import com.cpt.payments.pojo.Transaction;
import com.cpt.payments.service.interfaces.PaymentStatusHandler;

@Component
public class CreatedStatusHandler extends PaymentStatusHandler {

	@Override
	public String processStatus(Transaction payment) {
		// TODO Auto-generated method stub
		return "returning from CreatedStatusHandler";
	}

}