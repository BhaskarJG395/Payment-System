package com.cpt.payments.constant;

import lombok.Getter;

@Getter
public enum TransactionStatusEnum {
	CREATED(1, "CREATED"),
    INITIATED(2, "INITIATED"),
    PENDING(3, "PENDING"),
    SUCCESS(4, "SUCCESS"),
    FAILED(5, "FAILED");

    private final int id;
    private final String name;

    
    TransactionStatusEnum(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static TransactionStatusEnum getById(int id) {
        for (TransactionStatusEnum status : TransactionStatusEnum.values()) {
            if (status.getId() == id) {
                return status;
            }
        }
        throw new IllegalArgumentException("No enum constant with id " + id);
    }

    public static TransactionStatusEnum getByName(String name) {
        for (TransactionStatusEnum method : TransactionStatusEnum.values()) {
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
