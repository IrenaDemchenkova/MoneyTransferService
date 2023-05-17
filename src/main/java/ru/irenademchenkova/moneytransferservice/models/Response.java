package ru.irenademchenkova.moneytransferservice.models;

public class Response {
    public String operationId;

    public Response(String operationId) {
        this.operationId = operationId;
    }

    public String getOperationId() {
        return operationId;
    }
}
