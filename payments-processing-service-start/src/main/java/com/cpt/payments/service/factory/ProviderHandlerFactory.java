package com.cpt.payments.service.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.cpt.payments.constant.ProviderEnum;
import com.cpt.payments.service.impl.provider.handler.StripeProviderHandler;
import com.cpt.payments.service.interfaces.ProviderHandler;

@Component
public class ProviderHandlerFactory {
	@Autowired
	private ApplicationContext ctx;
		
	public ProviderHandler getProviderHandler(ProviderEnum providerEnum) {	
		switch(providerEnum) 
		{
		case STRIPE:
			StripeProviderHandler stripeProviderHandler = ctx.getBean(StripeProviderHandler.class);
			return stripeProviderHandler;
		default:
			System.out.println("not valid input.");
			break;
		}		
		return null;
	}
}