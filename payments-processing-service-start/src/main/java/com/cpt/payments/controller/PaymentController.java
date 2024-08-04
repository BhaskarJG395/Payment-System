package com.cpt.payments.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cpt.payments.pojo.Payment;
import com.cpt.payments.service.interfaces.PaymentStatusService;

@RestController
@RequestMapping("/v1/payments")
public class PaymentController {
	
	@Autowired
	private PaymentStatusService service;
	
	@PostMapping(value= {"","/"})
	public String createPayment(@RequestBody Payment payment) {
		System.out.println("****starting point of payment processing****");
		String valFormService = service.processStatus(payment);
		
		System.out.println("payment :"+payment+" valFormService : "+ valFormService);
		
		return "123 || "+valFormService;
	}
}
