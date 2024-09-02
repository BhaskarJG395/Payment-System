package com.cpt.payments.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cpt.payments.constant.ProviderEnum;
import com.cpt.payments.dto.InitiatePaymentReqDTO;
import com.cpt.payments.dto.TransactionDTO;
import com.cpt.payments.service.factory.ProviderHandlerFactory;
import com.cpt.payments.service.interfaces.PaymentService;
import com.cpt.payments.service.interfaces.ProviderHandler;

@Component
public class PaymentServiceImpl implements PaymentService {

	
	@Autowired
	private ProviderHandlerFactory providerHandlerFactory;

	@Override
	public String initiatePayment(InitiatePaymentReqDTO req) {
		// TODO Auto-generated method stub
		TransactionDTO dto = new TransactionDTO();
		dto.setTxnReference("TXN-9876-5498");
		dto.setProvider("STRIPE");
		ProviderEnum  provider = ProviderEnum.getByName(dto.getProvider());
		ProviderHandler providerHandler = providerHandlerFactory.getProviderHandler(provider);
		String providerResponse = providerHandler.processPayment(dto, req);
		
		return "from PaymentServiceImpl. "+"\n\n"
				+"providerResponse: "+providerResponse;
	}
}
