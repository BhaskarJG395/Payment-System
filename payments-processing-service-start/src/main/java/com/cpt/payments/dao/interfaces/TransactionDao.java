package com.cpt.payments.dao.interfaces;

import com.cpt.payments.dto.TransactionDTO;

public interface TransactionDao {
	public String createTransaction(TransactionDTO txnDTO);
}