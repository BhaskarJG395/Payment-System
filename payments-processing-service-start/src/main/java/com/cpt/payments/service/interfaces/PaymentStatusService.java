package com.cpt.payments.service.interfaces;

import com.cpt.payments.dto.TransactionDTO;

public interface PaymentStatusService {
	String processStatus(TransactionDTO transactionDTO);
}
