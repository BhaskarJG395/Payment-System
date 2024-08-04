package com.cpt.payments.service.interfaces;

import com.cpt.payments.pojo.Payment;

public abstract class PaymentStatusHandler {
	public abstract String processStatus(Payment payment);
}
