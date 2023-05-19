package ru.irenademchenkova.moneytransferservice.exceptions;

public class UnknownOperation extends RuntimeException {
    public UnknownOperation() {
        super("Unknown operation");
    }
}
