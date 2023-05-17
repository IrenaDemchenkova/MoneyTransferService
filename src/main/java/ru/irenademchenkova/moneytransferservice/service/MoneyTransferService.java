package ru.irenademchenkova.moneytransferservice.service;

import org.springframework.stereotype.Service;
import ru.irenademchenkova.moneytransferservice.models.Operation;
import ru.irenademchenkova.moneytransferservice.repository.OperationRepository;

import java.util.Random;


@Service
public class MoneyTransferService {
    private OperationRepository operationRepository;

    public MoneyTransferService(OperationRepository operationRepository) {
        this.operationRepository = operationRepository;
    }

    public void proceedOperation(Operation operation) {
        this.operationRepository.addOperationToList(operation);
    }

    public void confirmOperation (Operation operation){
        String code = generateCode();
        operation.setCode(code);
    }

    private String generateCode(){
        Random random = new Random();
        return String.format("%04d", random.nextInt(10000));
    }
}
