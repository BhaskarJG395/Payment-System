package com.cpt.payments.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cpt.payments.constant.TransactionStatusEnum;
import com.cpt.payments.dto.TransactionDTO;
import com.cpt.payments.entity.TransactionEntity;
import com.cpt.payments.service.factory.PaymentStatusFactory;
import com.cpt.payments.service.impl.handler.CreatedStatusHandler;
import com.cpt.payments.service.interfaces.PaymentStatusHandler;
import com.cpt.payments.service.interfaces.PaymentStatusService;
import com.cpt.payments.utils.StringToIntConverter;
//import com.cpt.payments.utils.StringToIntConverter;

@Component
public class PaymentStatusServiceImpl implements PaymentStatusService {
	@Autowired
	PaymentStatusFactory statusFactory ;
	
	@Autowired
	CreatedStatusHandler psh;
	
	
	
	@Override
	public String processStatus(TransactionDTO transactionDTO) {
		// TODO Auto-generated method stub
	
		StringToIntConverter stringToIntConverter = new StringToIntConverter();
		
		TransactionEntity transactionEntity = stringToIntConverter.convert(transactionDTO);
		
		System.out.println("from PayemntStausServiceImpl : "+transactionEntity);
		//systrace
		System.out.println("CreatedStatusHandler.processStatus() || payment "+transactionDTO);

		
		
		TransactionStatusEnum statusEnum = TransactionStatusEnum.getByName(transactionDTO.getTxnStatus());

		
		
		PaymentStatusHandler statusHandler = statusFactory.getStatusHandler(statusEnum);
		String processStatusResponse = psh.processStatus(transactionDTO);
		
		return "Returning from PaymentServiceImpl class \nstatusHandler : "+statusHandler +" ||" + processStatusResponse +"\ntransaction.getTxnStatusId():"+transactionDTO.getTxnStatus()+"\nstatusEnum : "+statusEnum;
	}
}
