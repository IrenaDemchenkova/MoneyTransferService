package ru.irenademchenkova.moneytransferservice.exceptions;

public class ErrorObject {
    static Integer idCounter =1;
    public Integer id;
    public String message;

    public ErrorObject(Integer id, String message) {
        this.id = id;
        this.message = message;
        idCounterSet();
    }

    private Integer idCounterSet (){
        idCounter=idCounter+1;
        return idCounter;
    }

    public static Integer idCounterGet(){
        return idCounter;
    }
}
