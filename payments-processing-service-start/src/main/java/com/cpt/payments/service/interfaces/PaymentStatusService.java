package com.cpt.payments.service.interfaces;

import com.cpt.payments.pojo.Payment;

public interface PaymentStatusService {
	String processStatus(Payment payment);
}
