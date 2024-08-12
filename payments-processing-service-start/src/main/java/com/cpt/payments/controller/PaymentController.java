package com.cpt.payments.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cpt.payments.constant.Endpoints;

import com.cpt.payments.dto.TransactionDTO;
import com.cpt.payments.service.interfaces.PaymentStatusService;

@RestController
@RequestMapping(Endpoints.V1_PAYMENTS)
public class PaymentController {
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private PaymentStatusService service;
	
	@PostMapping(value= {Endpoints.EMPTY_STRING,Endpoints.SLASH},consumes = MediaType.APPLICATION_JSON_VALUE)
	public String createPayment(@RequestBody TransactionDTO transaction) {
		System.out.println("****starting point of payment processing****");
		String valFormService = service.processStatus(transaction);
	
		//converting transaction to transactionDTO
		TransactionDTO txnDTO = mapper.map(transaction, TransactionDTO.class);
		
		System.out.print(txnDTO);
		System.out.println("transaction :"+transaction+" valFormService : "+ valFormService);
		
		return "123 || "+valFormService
				+ "\n" +txnDTO
				;
	}
}
