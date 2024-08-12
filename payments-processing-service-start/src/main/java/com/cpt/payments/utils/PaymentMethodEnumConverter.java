package com.cpt.payments.utils;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

import com.cpt.payments.constant.PaymentMethodEnum;


public class PaymentMethodEnumConverter implements Converter<String, Integer>{
	
	@Override
	public Integer convert(MappingContext<String, Integer> context) {
		return PaymentMethodEnum.getByName(context.getSource()).getId();
	}
}
