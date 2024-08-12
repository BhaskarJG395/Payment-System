package com.cpt.payments.utils;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import com.cpt.payments.constant.ProviderEnum;

public class ProviderEnumConverter implements Converter<String, Integer> {

    @Override
    public Integer convert(MappingContext<String, Integer> context) {
        return ProviderEnum.getByName(context.getSource()).getId();
    }
}
