package ru.irenademchenkova.moneytransferservice.service;

import org.springframework.stereotype.Service;
import ru.irenademchenkova.moneytransferservice.models.Operation;
import ru.irenademchenkova.moneytransferservice.repository.OperationRepository;


@Service
public class MoneyTransferService {
    private OperationRepository operationRepository;

    public MoneyTransferService(OperationRepository operationRepository) {
        this.operationRepository = operationRepository;
    }

    public void proceedOperation(Operation operation) {
        this.operationRepository.addOperationToList(operation);
    }
}
