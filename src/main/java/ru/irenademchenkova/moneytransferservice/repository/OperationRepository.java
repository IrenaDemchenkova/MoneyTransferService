package ru.irenademchenkova.moneytransferservice.repository;

import ru.irenademchenkova.moneytransferservice.exceptions.UnknownOperation;
import ru.irenademchenkova.moneytransferservice.models.ConfirmOperation;
import ru.irenademchenkova.moneytransferservice.models.Operation;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public interface OperationRepository {
    ConcurrentHashMap<Integer, Operation> getOperationList();

    AtomicLong getOperationId();

    String addOperationToList(Operation operation);

    String updateOperation(ConfirmOperation operation) throws UnknownOperation;
}
