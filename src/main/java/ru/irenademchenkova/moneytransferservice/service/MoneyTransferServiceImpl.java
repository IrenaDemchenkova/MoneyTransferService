package ru.irenademchenkova.moneytransferservice.service;

import org.springframework.stereotype.Service;
import ru.irenademchenkova.moneytransferservice.models.ConfirmOperation;
import ru.irenademchenkova.moneytransferservice.models.Operation;
import ru.irenademchenkova.moneytransferservice.repository.OperationRepository;

@Service
public class MoneyTransferServiceImpl implements MoneyTransferService {
    private final OperationRepository operationRepository;

    public MoneyTransferServiceImpl(OperationRepository operationRepository) {
        this.operationRepository = operationRepository;
    }

    @Override
    public String proceedOperation(Operation operation) {
        return operationRepository.addOperationToList(operation);
    }

    @Override
    public String confirmOperation(ConfirmOperation operation) {
        return operationRepository.updateOperation(operation);
    }
}
