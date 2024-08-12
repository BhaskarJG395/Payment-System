package com.cpt.payments.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cpt.payments.constant.PaymentMethodEnum;
import com.cpt.payments.constant.PaymentTypeEnum;
import com.cpt.payments.constant.ProviderEnum;
import com.cpt.payments.constant.TransactionStatusEnum;
import com.cpt.payments.dto.TransactionDTO;
import com.cpt.payments.entity.TransactionEntity;


public class StringToIntConverter {
	
	TransactionEntity transactionEntity=new TransactionEntity();
	
	public TransactionEntity convert(TransactionDTO transactionDTO) {
		
System.out.println("bbbbb");
System.out.println(transactionDTO);

		String paymentMethod= transactionDTO.getPaymentMethod();		
		String provider =  transactionDTO.getProvider();
		String paymentType= transactionDTO.getPaymentType();
		String txnStatus= transactionDTO.getTxnStatus();
		
		System.out.println(paymentMethod+" //// "+provider +" //// "+paymentType+" //// "+txnStatus);		

		
		int paymentMethodId = PaymentMethodEnum.getByName(paymentMethod).getId();
		int providerId = ProviderEnum.getByName(provider).getId();
		int paymentTypeId = PaymentTypeEnum.getByName(paymentType).getId();
		int txnStatusId = TransactionStatusEnum.getByName(txnStatus).getId();
		System.out.println(paymentMethodId+" //// "+providerId +" //// "+paymentTypeId+" //// "+txnStatusId);				

		 // Set the converted IDs in the entity
		
		transactionEntity.setPaymentMethodId(paymentMethodId);
		transactionEntity.setProviderId(providerId);
        transactionEntity.setPaymentTypeId(paymentTypeId);
        transactionEntity.setTxnStatusId(txnStatusId);
        
        transactionEntity.setId(transactionDTO.getId());
        transactionEntity.setUserId(transactionDTO.getUserId());
        transactionEntity.setAmount(transactionDTO.getAmount());
        transactionEntity.setCurrency(transactionDTO.getCurrency());
        
        transactionEntity.setMerchantTransactionReference(transactionDTO.getMerchantTransactionReference());
        transactionEntity.setTxnReference(transactionDTO.getTxnReference());
        transactionEntity.setProviderReference(transactionDTO.getProviderReference());
        transactionEntity.setProviderCode(transactionDTO.getProviderCode());

        System.out.println("transactionEntity : "+transactionEntity);		

        System.out.println("fff");
        // Return the populated TransactionEntity
        return transactionEntity;
	}
}
