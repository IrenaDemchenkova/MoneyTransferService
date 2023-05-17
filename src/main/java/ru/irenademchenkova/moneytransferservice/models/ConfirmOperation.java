package ru.irenademchenkova.moneytransferservice.models;

public class ConfirmOperation {
    private String operationId;

    public ConfirmOperation() {
    }

    public ConfirmOperation(String operationId) {
        this.operationId = operationId;
    }

    public String getOperationId() {
        return this.operationId;
    }

    @Override
    public String toString() {
        return "ConfirmOperation{" +
                "operationId='" + operationId + '\'' +
                '}';
    }
}
