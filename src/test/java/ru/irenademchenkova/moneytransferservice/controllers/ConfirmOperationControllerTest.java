package ru.irenademchenkova.moneytransferservice.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import ru.irenademchenkova.moneytransferservice.models.ConfirmOperation;
import ru.irenademchenkova.moneytransferservice.models.Response;
import ru.irenademchenkova.moneytransferservice.service.MoneyTransferService;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ConfirmOperationControllerTest {
    @Mock
    private MoneyTransferService moneyTransferService;

    @InjectMocks
    private ConfirmOperationController confirmOperationController;

    @Test
    void MoneyTransferTest() {
        ConfirmOperation operation = mock(ConfirmOperation.class);
        when(operation.getOperationId()).thenReturn(String.valueOf(1));

        ResponseEntity<Response> responseActual = confirmOperationController.moneyTransfer(operation);
        verify(moneyTransferService).confirmOperation(operation);
        assertNotNull(responseActual);
    }
}