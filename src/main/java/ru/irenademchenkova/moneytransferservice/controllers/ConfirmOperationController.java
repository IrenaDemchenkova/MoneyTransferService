package ru.irenademchenkova.moneytransferservice.controllers;


import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.irenademchenkova.moneytransferservice.models.Operation;
import ru.irenademchenkova.moneytransferservice.models.Response;
import ru.irenademchenkova.moneytransferservice.service.MoneyTransferService;
@Slf4j
@CrossOrigin
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
