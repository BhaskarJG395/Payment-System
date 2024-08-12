package com.cpt.payments.dao.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cpt.payments.dao.interfaces.TransactionDao;
import com.cpt.payments.dto.TransactionDTO;
import com.cpt.payments.entity.TransactionEntity;

@Component
public class TransactionDaoImpl implements TransactionDao {
	
	@Autowired
	private ModelMapper mapper;
	
	public String createTransaction(TransactionDTO txnDTO) {
		
		TransactionDTO txnEntity =mapper.map(txnDTO, TransactionDTO.class);
		
		System.out.println("TransactionDaoImpl.createTransaction()");
		return "\n from TransactionDaoImpl class \n"+"txnEntity: "+txnEntity; 
	}
}
