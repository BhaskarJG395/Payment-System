package com.cpt.payments.constant;

import lombok.Getter;

@Getter
public enum ProviderEnum {
    STRIPE(1, "STRIPE"),
    PAYPAL(2, "PAYPAL"),
    SQUARE(3, "SQUARE");

    private final int id;
    private final String name;

    ProviderEnum(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Method to get enum by name
    public static ProviderEnum getByName(String name) {
        for (ProviderEnum provider : ProviderEnum.values()) {
            if (provider.getName().equalsIgnoreCase(name)) {
                return provider;
            }
        }
        throw new IllegalArgumentException("No enum constant with name " + name);
    }

    @Override
    public String toString() {
        return name;
    }
}
