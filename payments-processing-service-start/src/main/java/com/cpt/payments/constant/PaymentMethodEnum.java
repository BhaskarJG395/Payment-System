package com.cpt.payments.constant;

import lombok.Getter;

@Getter
public enum PaymentMethodEnum {
    APM(1, "APM"),
    CREDIT_CARD(2, "CREDIT_CARD"),
    DEBIT_CARD(3, "DEBIT_CARD"),
    NET_BANKING(4, "NET_BANKING"),
    UPI(5, "UPI"),
    WALLET(6, "WALLET"),
    PAYPAL(7, "PAYPAL"),
    CRYPTO(8, "CRYPTO");

    private final int id;
    private final String name;

    PaymentMethodEnum(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static PaymentMethodEnum getById(int id) {
        for (PaymentMethodEnum method : PaymentMethodEnum.values()) {
            if (method.getId() == id) {
                return method;
            }
        }
        throw new IllegalArgumentException("No enum constant with id " + id);
    }

    public static PaymentMethodEnum getByName(String name) {
        for (PaymentMethodEnum method : PaymentMethodEnum.values()) {
            if (method.getName().equalsIgnoreCase(name)) {
                return method;
            }
        }
        throw new IllegalArgumentException("No enum constant with name " + name);
    }

    @Override
    public String toString() {
        return name;
    }
}
