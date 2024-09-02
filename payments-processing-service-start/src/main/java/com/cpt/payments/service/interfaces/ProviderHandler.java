package com.cpt.payments.service.interfaces;

import com.cpt.payments.dto.InitiatePaymentReqDTO;
import com.cpt.payments.dto.TransactionDTO;
//import com.cpt.payments.pojo.InitiatePaymentReq;

public interface ProviderHandler {
	
	public String processPayment(TransactionDTO txn ,InitiatePaymentReqDTO req);
}
