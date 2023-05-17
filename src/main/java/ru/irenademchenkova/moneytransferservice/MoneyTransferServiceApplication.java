package ru.irenademchenkova.moneytransferservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class MoneyTransferServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(MoneyTransferServiceApplication.class, args);
    }
}
