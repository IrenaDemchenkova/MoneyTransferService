package ru.irenademchenkova.moneytransferservice.controllers;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.irenademchenkova.moneytransferservice.models.ConfirmOperation;
import ru.irenademchenkova.moneytransferservice.models.Response;
import ru.irenademchenkova.moneytransferservice.service.MoneyTransferService;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/confirmOperation")
public class ConfirmOperationController {
    private final Logger logger = LoggerFactory.getLogger(ConfirmOperationController.class);
    private final MoneyTransferService moneyTransferService;

    public ConfirmOperationController(MoneyTransferService moneyTransferService) {
        this.moneyTransferService = moneyTransferService;
    }

    @PostMapping
    public ResponseEntity<Response> moneyTransfer(@Valid @RequestBody ConfirmOperation operation) {
        this.logger.info("Confirmed operation {}", operation.getOperationId());
        return ResponseEntity.ok(new Response(this.moneyTransferService.confirmOperation(operation)));
    }
}
