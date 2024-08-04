package com.cpt.payments.service.impl.handler;

import com.cpt.payments.pojo.Payment;
import com.cpt.payments.service.interfaces.PaymentStatusHandler;

public class CreatedStatusHandler extends PaymentStatusHandler {

	@Override
	public String processStatus(Payment payment) {
		// TODO Auto-generated method stub
		return "returning from CreatedStatusHandler";
	}

}
