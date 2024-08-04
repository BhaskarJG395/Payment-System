package com.cpt.payments.service.factory;

import com.cpt.payments.service.impl.handler.CreatedStatusHandler;
import com.cpt.payments.service.interfaces.PaymentStatusHandler;

public class PaymentStatusFactory {
	public PaymentStatusHandler getStatusHandler(String status) {
		if(status.equals("CREATED") && status != null ) {
			return new CreatedStatusHandler();
		}
		return new CreatedStatusHandler();
	}
}
