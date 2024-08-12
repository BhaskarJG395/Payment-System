package com.cpt.payments.service.interfaces;

import com.cpt.payments.dto.TransactionDTO;

public abstract class PaymentStatusHandler {
	public abstract String processStatus(TransactionDTO transactionDTO);

}
