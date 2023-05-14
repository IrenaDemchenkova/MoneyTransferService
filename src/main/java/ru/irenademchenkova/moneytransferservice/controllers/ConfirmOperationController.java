package ru.irenademchenkova.moneytransferservice.controllers;


import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.irenademchenkova.moneytransferservice.models.Operation;
import ru.irenademchenkova.moneytransferservice.models.Response;
import ru.irenademchenkova.moneytransferservice.service.MoneyTransferService;
@Slf4j
@RestController
@RequestMapping("/confirmOperation")
public class ConfirmOperationController {
    private final MoneyTransferService moneyTransferService;

    public ConfirmOperationController(MoneyTransferService moneyTransferService) {
        this.moneyTransferService = moneyTransferService;
    }

    @PostMapping
    public Response moneyTransfer(@Valid @RequestBody Operation operation) {
       moneyTransferService.proceedOperation(operation);
       return new Response(operation.getOperationId());
    }
}
