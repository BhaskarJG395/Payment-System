package com.cpt.payments.dao.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import com.cpt.payments.dao.interfaces.TransactionDao;
import com.cpt.payments.dto.TransactionDTO;
import com.cpt.payments.entity.TransactionEntity;
import com.cpt.payments.utils.StringToIntConverter;

@Component
public class TransactionDaoImpl implements TransactionDao {
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private StringToIntConverter stringToIntConverter;	
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate; 
	
	public TransactionDaoImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate=namedParameterJdbcTemplate;
	}
	

	public TransactionDTO createTransaction(TransactionDTO txnDTO) {
		System.out.println(namedParameterJdbcTemplate);
		//TransactionDTO txnEntity = mapper.map(txnDTO, TransactionDTO.class);
		TransactionEntity txnEntity = stringToIntConverter.convert(txnDTO);
		System.out.println("TransactionDaoImpl.createTransaction()");

		String sql = "INSERT INTO `Transaction` (id, userId, paymentMethodId, providerId, paymentTypeId, txnStatusId, amount, currency, merchantTransactionReference, txnReference, providerReference, providerCode) " +
	             "VALUES (:id, :userId, :paymentMethodId, :providerId, :paymentTypeId, :txnStatusId, :amount, :currency, :merchantTransactionReference, :txnReference, :providerReference, :providerCode)";

		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		int insertedRowCount = namedParameterJdbcTemplate.update(sql, new BeanPropertySqlParameterSource(txnEntity),keyHolder,new String[] {"id"});
		int transactionId = (keyHolder.getKey() != null) ? keyHolder.getKey().intValue() : -1;
		txnDTO.setId(transactionId);
		
		System.out.println("\n from TransactionDaoImpl class \n"
				+"3_2."+"txnEntity: "+txnEntity+"\n"
				+"3_3."+ "insertedRowCount: "+insertedRowCount+"\n"
				+"3_4."+"transactionId: "+transactionId
				); 
		return txnDTO;
	}
}
