package com.cpt.payments.constant;

import lombok.Getter;

@Getter
public enum PaymentTypeEnum {
    SALE(1, "SALE"),
    REFUND(2, "REFUND"),
    AUTHORIZATION(3, "AUTHORIZATION"),
    CAPTURE(4, "CAPTURE"),
    VOID(5, "VOID");

    private final int id;
    private final String name;

    PaymentTypeEnum(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static PaymentTypeEnum getById(int id) {
        for (PaymentTypeEnum method : PaymentTypeEnum.values()) {
            if (method.getId() == id) {
                return method;
            }
        }
        throw new IllegalArgumentException("No enum constant with id " + id);
    }

    public static PaymentTypeEnum getByName(String name) {
        for (PaymentTypeEnum method : PaymentTypeEnum.values()) {
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
