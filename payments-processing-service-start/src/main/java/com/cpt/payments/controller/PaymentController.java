package com.cpt.payments.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cpt.payments.constant.Endpoints;
import com.cpt.payments.dto.InitiatePaymentReqDTO;
import com.cpt.payments.dto.TransactionDTO;
import com.cpt.payments.pojo.InitiatePaymentReq;
import com.cpt.payments.pojo.TransactionResponse;
import com.cpt.payments.service.impl.PaymentServiceImpl;
import com.cpt.payments.service.interfaces.PaymentService;
import com.cpt.payments.service.interfaces.PaymentStatusService;

@RestController
@RequestMapping(Endpoints.V1_PAYMENTS)
public class PaymentController {
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private PaymentService paymentService;
	
	@Autowired
	private PaymentStatusService service;
	
	@Autowired
	private PaymentServiceImpl paymentServiceImpl;
	
	@PostMapping(value= {Endpoints.EMPTY_STRING,Endpoints.SLASH},consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createPayment(@RequestBody TransactionDTO transaction) {
		System.out.println("****starting point of payment processing****");
		
		TransactionDTO valFormService = service.processStatus(transaction);
		
		//converting transaction to transactionDTO
		TransactionDTO txnDTO = mapper.map(transaction, TransactionDTO.class);
		
		System.out.print(txnDTO);
		System.out.println("transaction :"+transaction
				+" valFormService : "+ valFormService
				+"txnDTO"+txnDTO);
		
		TransactionResponse txnResponse= new TransactionResponse();
		txnResponse.setId(txnDTO.getId());
		txnResponse.setTxnStatus(txnDTO.getTxnStatus());
		
		ResponseEntity<?> response = new ResponseEntity(txnResponse,HttpStatus.CREATED);
		
		return response;
	}
	
	@PostMapping(Endpoints.PAYMENT_INITIATE)
	public ResponseEntity<String> createPayment(@PathVariable int id,@RequestBody InitiatePaymentReq paymentReq) {
		
		InitiatePaymentReqDTO reqDto = mapper.map(paymentReq,InitiatePaymentReqDTO.class);
		reqDto.setId(id);

		String paymentServiceResponse = paymentService.initiatePayment(reqDto);

		return new ResponseEntity("returning from createPayment method of controller. || txnId: "
		+id+"\n"
		+"paymentReq: "+paymentReq+"\n\n"
		+"paymentServiceImpl: "+paymentServiceResponse,HttpStatus.OK);
	
	}
}
