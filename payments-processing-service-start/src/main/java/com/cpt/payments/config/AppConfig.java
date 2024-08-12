package com.cpt.payments.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//import com.cpt.payments.utils.StringToIntConverter;

@Configuration
public class AppConfig {
	
	@Bean
	ModelMapper getModelMapper() {
	
		ModelMapper modelMapper = new ModelMapper();
		return new ModelMapper();
	}
//	@Bean
//	public StringToIntConverter stringToIntConverter() {
//	     return new StringToIntConverter();
//	}
}




//		Converter<String, Integer> paymentMethodEnumConverter= (Converter<String, Integer>)new PaymentMethodEnumConverter();
//		Converter<String, Integer> paymentTypeEnumConverter= (Converter<String, Integer>)new PaymentTypeEnumConverter();
//		Converter<String, Integer> providerEnumConverter= (Converter<String, Integer>) new ProviderEnumConverter();
//		Converter<String, Integer> txnStatusEnumConverter= (Converter<String, Integer>)new TxnStatusEnumConverter();
//
//	modelMapper.addMappings(new PropertyMap<TransactionDTO, TransactionEntity>(){
//		@Override
//		protected void configure() {
//			using((org.modelmapper.Converter<String, Integer>) providerEnumConverter).map(source.getProvider(),destination.getProviderId());
//			using((org.modelmapper.Converter<String, Integer>) paymentTypeEnumConverter).map(source.getPaymentType(),destination.getPaymentTypeId());
//			using((org.modelmapper.Converter<String, Integer>) paymentMethodEnumConverter).map(source.getPaymentMehotd(),destination.getPaymentMehotdId());
//			using((org.modelmapper.Converter<String, Integer>) txnStatusEnumConverter).map(source.getTxnStatus(),destination.getTxnStatusId());
//		}
//	});		
	

