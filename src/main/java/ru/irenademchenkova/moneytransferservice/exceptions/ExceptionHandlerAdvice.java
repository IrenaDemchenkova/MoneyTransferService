package ru.irenademchenkova.moneytransferservice.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class ExceptionHandlerAdvice {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorObject>> handleArgumentNotValidException(MethodArgumentNotValidException e) {
        var errors = e.getBindingResult().getFieldErrors().stream()
                .map(fieldError -> new ErrorObject(ErrorObject.idCounterGet(), fieldError.getDefaultMessage()))
                .toList();
        return ResponseEntity.badRequest().body(errors);
    }
}
