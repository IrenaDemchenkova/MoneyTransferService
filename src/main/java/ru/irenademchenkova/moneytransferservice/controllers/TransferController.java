package ru.irenademchenkova.moneytransferservice.controllers;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.irenademchenkova.moneytransferservice.models.Operation;
import ru.irenademchenkova.moneytransferservice.models.Response;
import ru.irenademchenkova.moneytransferservice.service.MoneyTransferService;

@CrossOrigin
@RestController
@RequestMapping("/transfer")
public class TransferController {
    private final MoneyTransferService moneyTransferService;
    private final Logger logger = LoggerFactory.getLogger(TransferController.class);

    public TransferController(MoneyTransferService transferService) {
        this.moneyTransferService = transferService;
    }

    @PostMapping
    public ResponseEntity<Response> moneyTransfer(@Valid @RequestBody Operation operation) {
        this.moneyTransferService.proceedOperation(operation);
        if (operation.getAmount() != null) {
            this.logger.info(
                    "Transfer from {} to {}: {}{}",
                    operation.getCardFromNumber(),
                    operation.getCardToNumber(),
                    operation.getAmount().getValue(),
                    operation.getAmount().getCurrency()
            );
        }
        return ResponseEntity.ok(new Response(operation.getOperationId()));
    }
}

