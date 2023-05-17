package ru.irenademchenkova.moneytransferservice.repository;

import org.springframework.stereotype.Repository;
import ru.irenademchenkova.moneytransferservice.models.ConfirmOperation;
import ru.irenademchenkova.moneytransferservice.models.Operation;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class OperationRepository {
    private final Map<Integer, Operation> operationList = new HashMap<>();
    private final AtomicLong operationId = new AtomicLong(1L);

    public Map<Integer, Operation> getOperationList() {
        return operationList;
    }

    public AtomicLong getOperationId() {
        return operationId;
    }

    public void addOperationToList(Operation operation) {
        operationList.put(operationId.intValue(), operation);
        operation.setOperationId(operationId.toString());
        operationId.addAndGet(1);
    }

    public String updateOperation(ConfirmOperation operation) throws RuntimeException {
        if (operationList.get(Integer.parseInt(operation.getOperationId())) == null) {
            throw new RuntimeException("Unknown operation");
        }

        this.operationList.get(Integer.parseInt(operation.getOperationId())).setOperationId(operation.getOperationId());
        return operation.getOperationId();
    }
}

