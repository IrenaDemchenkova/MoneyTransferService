package ru.irenademchenkova.moneytransferservice.models;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class Operation {
    private String operationId;
    @NotBlank
    @Digits(integer = 16, fraction = 0)
    private String cardFromNumber;
    @NotBlank
    @Pattern(regexp = "^(0[1-9]|1[0-2])([\\/])([2-9][0-9])$")
    private String cardFromValidTill;
    @NotBlank
    @Digits(integer = 3, fraction = 0)
    private String cardFromCVV;
    @NotBlank
    @Digits(integer = 16, fraction = 0)
    private String cardToNumber;
    @Valid
    private Amount amount;

    public Operation() {
    }

    public String getOperationId() {
        return operationId;
    }

    public void setOperationId(String operationId) {
        this.operationId = operationId;
    }

    public String getCardFromNumber() {
        return cardFromNumber;
    }

    public void setCardFromNumber(String cardFromNumber) {
        this.cardFromNumber = cardFromNumber;
    }

    public String getCardFromValidTill() {
        return cardFromValidTill;
    }

    public void setCardFromValidTill(String cardFromValidTill) {
        this.cardFromValidTill = cardFromValidTill;
    }

    public String getCardFromCVV() {
        return cardFromCVV;
    }

    public void setCardFromCVV(String cardFromCVV) {
        this.cardFromCVV = cardFromCVV;
    }

    public String getCardToNumber() {
        return cardToNumber;
    }

    public void setCardToNumber(String cardToNumber) {
        this.cardToNumber = cardToNumber;
    }

    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "operationId='" + operationId + '\'' +
                ", cardFromNumber='" + cardFromNumber + '\'' +
                ", cardFromValidTill='" + cardFromValidTill + '\'' +
                ", cardFromCVV='" + cardFromCVV + '\'' +
                ", cardToNumber='" + cardToNumber + '\'' +
                ", amount=" + amount +
                '}';
    }
}

