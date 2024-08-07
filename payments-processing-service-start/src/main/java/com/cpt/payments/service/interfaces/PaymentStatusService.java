package com.cpt.payments.service.interfaces;

import com.cpt.payments.pojo.Transaction;

public interface PaymentStatusService {
	String processStatus(Transaction transaction);
}
