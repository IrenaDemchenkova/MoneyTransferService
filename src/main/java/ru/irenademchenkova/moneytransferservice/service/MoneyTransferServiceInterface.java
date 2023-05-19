package ru.irenademchenkova.moneytransferservice.service;

import ru.irenademchenkova.moneytransferservice.models.ConfirmOperation;
import ru.irenademchenkova.moneytransferservice.models.Operation;

public interface MoneyTransferServiceInterface {
    String proceedOperation(Operation operation);
    String confirmOperation(ConfirmOperation operation);
}
