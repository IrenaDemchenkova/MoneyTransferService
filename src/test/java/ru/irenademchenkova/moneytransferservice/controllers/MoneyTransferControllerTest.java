package ru.irenademchenkova.moneytransferservice.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import ru.irenademchenkova.moneytransferservice.models.ConfirmOperation;
import ru.irenademchenkova.moneytransferservice.models.Operation;
import ru.irenademchenkova.moneytransferservice.models.Response;
import ru.irenademchenkova.moneytransferservice.service.MoneyTransferService;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MoneyTransferControllerTest {
    @Mock
    private MoneyTransferService moneyTransferService;

    @InjectMocks
    private MoneyTransferController moneyTransferController;

    @Test
    void confirmOperation() {
        ConfirmOperation operation = mock(ConfirmOperation.class);
        when(operation.operationId()).thenReturn(String.valueOf(1));

        ResponseEntity<Response> responseActual = moneyTransferController.confirmOperation(operation);
        verify(moneyTransferService).confirmOperation(operation);
        assertNotNull(responseActual);
    }

    @Test
    void moneyTransfer() {
        Operation operation = mock(Operation.class);
        ResponseEntity<Response> responseActual = moneyTransferController.transfer(operation);

        verify(moneyTransferService).proceedOperation(operation);
        assertNotNull(responseActual);
    }
}