package ru.irenademchenkova.moneytransferservice.exceptions;

public class ErrorObject {
    private static Integer idCounter = 1;
    public Integer id;
    public String message;

    public ErrorObject(Integer id, String message) {
        this.id = id;
        this.message = message;
        incrementCounter();
    }

    public static Integer getIdCounter() {
        return idCounter;
    }

    private void incrementCounter() {
        idCounter += 1;
    }
}
