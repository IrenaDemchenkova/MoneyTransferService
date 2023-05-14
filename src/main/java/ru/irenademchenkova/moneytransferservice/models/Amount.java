package ru.irenademchenkova.moneytransferservice.models;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class Amount {

    @Min(1)
    private Integer value;
    @NotBlank
    private String currency;

    public Amount() {}

    public Amount(Integer value, String currency) {
        this.value = value;
        this.currency = currency;
    }

    public int getValue() {
        return value;
    }

    public String getCurrency() {
        return currency;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Amount{" +
                "value " + value +
                ", currency '" + currency + '\'' +
                '}';
    }
}
