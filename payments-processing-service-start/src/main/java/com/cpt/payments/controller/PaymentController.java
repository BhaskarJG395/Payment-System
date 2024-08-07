package com.cpt.payments.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cpt.payments.constant.Endpoints;
import com.cpt.payments.pojo.Transaction;
import com.cpt.payments.service.interfaces.PaymentStatusService;

@RestController
@RequestMapping(Endpoints.V1_PAYMENTS)
public class PaymentController {
	
	@Autowired
	private PaymentStatusService service;
	
	@PostMapping(value= {Endpoints.EMPTY_STRING,Endpoints.SLASH},consumes = MediaType.APPLICATION_JSON_VALUE)
	public String createPayment(@RequestBody Transaction transaction) {
		System.out.println("****starting point of payment processing****");
		String valFormService = service.processStatus(transaction);
		
		System.out.println("transaction :"+transaction+" valFormService : "+ valFormService);
		
		return "123 || "+valFormService;
	}
}
