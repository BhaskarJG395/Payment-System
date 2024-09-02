package com.cpt.payments.service.interfaces;

import com.cpt.payments.dto.InitiatePaymentReqDTO;
import com.cpt.payments.pojo.InitiatePaymentReq;

public interface PaymentService {
	public String initiatePayment(InitiatePaymentReqDTO reqDto);
}
