package ru.irenademchenkova.moneytransferservice.service;

import org.springframework.stereotype.Service;
import ru.irenademchenkova.moneytransferservice.models.ConfirmOperation;
import ru.irenademchenkova.moneytransferservice.models.Operation;
import ru.irenademchenkova.moneytransferservice.repository.OperationRepository;

@Service
public class MoneyTransferService {
    private final OperationRepository operationRepository;

    public MoneyTransferService(OperationRepository operationRepository) {
        this.operationRepository = operationRepository;
    }

    public void proceedOperation(Operation operation) {
        this.operationRepository.addOperationToList(operation);
    }

    public String confirmOperation(ConfirmOperation operation) {
        return this.operationRepository.updateOperation(operation);
    }
}
