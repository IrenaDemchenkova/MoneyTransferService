package ru.irenademchenkova.moneytransferservice.controllers;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.irenademchenkova.moneytransferservice.models.ConfirmOperation;
import ru.irenademchenkova.moneytransferservice.models.Operation;
import ru.irenademchenkova.moneytransferservice.models.Response;
import ru.irenademchenkova.moneytransferservice.service.MoneyTransferService;

@CrossOrigin
@RestController
public class MoneyTransferController {
    private final Logger logger = LoggerFactory.getLogger(MoneyTransferController.class);
    private final MoneyTransferService moneyTransferService;

    public MoneyTransferController(MoneyTransferService moneyTransferService) {
        this.moneyTransferService = moneyTransferService;
    }

    @PostMapping("/confirmOperation")
    public ResponseEntity<Response> confirmOperation(@Valid @RequestBody ConfirmOperation operation) {
        logger.info("Confirming operation {}...", operation.operationId());

        String operationId = moneyTransferService.confirmOperation(operation);
        logger.info("Confirmed operation {}", operationId);

        return ResponseEntity.ok(new Response(operationId));
    }

    @PostMapping("/transfer")
    public ResponseEntity<Response> transfer(@Valid @RequestBody Operation operation) {
        logger.info("Processing operation {}...", operation);

        String operationId = moneyTransferService.proceedOperation(operation);
        logger.info("Processed operation {} with id {}", operation, operationId);

        return ResponseEntity.ok(new Response(operationId));
    }
}
