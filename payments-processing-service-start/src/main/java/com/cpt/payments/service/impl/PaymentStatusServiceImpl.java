package com.cpt.payments.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpt.payments.constant.ProviderEnum;
import com.cpt.payments.constant.TransactionStatusEnum;
import com.cpt.payments.dto.TransactionDTO;
import com.cpt.payments.entity.TransactionEntity;
import com.cpt.payments.service.factory.PaymentStatusFactory;
import com.cpt.payments.service.factory.ProviderHandlerFactory;
import com.cpt.payments.service.impl.handler.CreatedStatusHandler;
import com.cpt.payments.service.interfaces.PaymentStatusHandler;
import com.cpt.payments.service.interfaces.PaymentStatusService;
import com.cpt.payments.service.interfaces.ProviderHandler;
import com.cpt.payments.utils.StringToIntConverter;

@Service
public class PaymentStatusServiceImpl implements PaymentStatusService {

	
	@Autowired
	private PaymentStatusFactory statusFactory;
	
	@Autowired
	private CreatedStatusHandler psh;

	@Autowired
	private StringToIntConverter stringToIntConverter;	
	
	@Override
	public TransactionDTO processStatus(TransactionDTO transactionDTO) {
		System.out.println("check here1");
		TransactionEntity transactionEntity = stringToIntConverter.convert(transactionDTO);
		System.out.println("check here2");
		System.out.println("from PaymentStatusServiceImpl : " + transactionEntity);
		System.out.println("CreatedStatusHandler.processStatus() || payment " + transactionDTO);

		TransactionStatusEnum statusEnum = TransactionStatusEnum.getByName(transactionDTO.getTxnStatus());
		System.out.println("check here3");
		PaymentStatusHandler statusHandler = statusFactory.getStatusHandler(statusEnum);
		System.out.println("check here4");
		TransactionDTO processStatusResponse = psh.processStatus(transactionDTO);

		System.out.println("Returning from PaymentServiceImpl class \n"
				+"2.statusHandler : " + statusHandler + "\n"
				+ "3." + processStatusResponse+"\n"
				+ "4."+"transaction.getTxnStatusId():" + transactionDTO.getTxnStatus()+"\n" 
				+ "5."+"statusEnum : " + statusEnum+"\n"
				+ "6."+transactionEntity);
		
//		ProviderHandler providerHandler=providerHandlerFactory.getProviderHandler(ProviderEnum.STRIPE);
//		System.out.println(" _________ "+ providerHandler);
		
		return processStatusResponse;
	}
}
