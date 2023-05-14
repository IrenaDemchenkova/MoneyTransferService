package ru.irenademchenkova.moneytransferservice.exceptions;

public class ErrorObject {
    public Integer id;
    public String message;

    public ErrorObject(Integer id, String message) {
        this.id = id;
        this.message = message;
    }
}
