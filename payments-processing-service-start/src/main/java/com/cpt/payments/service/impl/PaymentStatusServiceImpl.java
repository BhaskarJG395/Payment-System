package com.cpt.payments.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpt.payments.constant.TransactionStatusEnum;
import com.cpt.payments.dto.TransactionDTO;
import com.cpt.payments.entity.TransactionEntity;
import com.cpt.payments.service.factory.PaymentStatusFactory;
import com.cpt.payments.service.impl.handler.CreatedStatusHandler;
import com.cpt.payments.service.interfaces.PaymentStatusHandler;
import com.cpt.payments.service.interfaces.PaymentStatusService;
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
	public String processStatus(TransactionDTO transactionDTO) {

		TransactionEntity transactionEntity = stringToIntConverter.convert(transactionDTO);

		System.out.println("from PaymentStatusServiceImpl : " + transactionEntity);
		System.out.println("CreatedStatusHandler.processStatus() || payment " + transactionDTO);

		TransactionStatusEnum statusEnum = TransactionStatusEnum.getByName(transactionDTO.getTxnStatus());

		PaymentStatusHandler statusHandler = statusFactory.getStatusHandler(statusEnum);
		String processStatusResponse = psh.processStatus(transactionDTO);

		return "Returning from PaymentServiceImpl class \nstatusHandler : " + statusHandler + " ||" + processStatusResponse + "\ntransaction.getTxnStatusId():" + transactionDTO.getTxnStatus() + "\nstatusEnum : " + statusEnum;
	}
}
