package com.cpt.payments.service.impl.provider.handler;

import java.util.HashMap;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cpt.payments.dto.InitiatePaymentReqDTO;
import com.cpt.payments.dto.TransactionDTO;
import com.cpt.payments.service.http.HttpServiceEngine;
import com.cpt.payments.service.interfaces.ProviderHandler;
import com.cpt.payments.stripeprovider.CreatePaymentReq;

@Service	
public class StripeProviderHandler implements ProviderHandler {

	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private HttpServiceEngine httpServiceEngine;
	
	@Override
	public String processPayment(TransactionDTO txn,InitiatePaymentReqDTO req) {
		// TODO Auto-generated method stub
		
		CreatePaymentReq createPaymentReq = mapper.map(req, CreatePaymentReq.class);
		createPaymentReq.setTxnRef(txn.getTxnReference());
		
		String url = "http://localhost:8086/v1/payments";
		Map<String,String> headers = new HashMap<>();
		headers.put("Content-Type", "application/json");
 		
		ResponseEntity<String> response =httpServiceEngine.makeHttpRequest(url, HttpMethod.POST, createPaymentReq, String.class, headers);
 		
 		if(response.getStatusCode().is2xxSuccessful()) {
 			return "Payment successful: "+response.getBody();
 		}
 		else {
 			return "Payment failed: "+ response.getStatusCode();
 		}
	}

}
