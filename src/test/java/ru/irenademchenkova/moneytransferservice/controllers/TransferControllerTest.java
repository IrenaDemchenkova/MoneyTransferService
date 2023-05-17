package ru.irenademchenkova.moneytransferservice.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.irenademchenkova.moneytransferservice.models.Operation;
import ru.irenademchenkova.moneytransferservice.models.Response;
import ru.irenademchenkova.moneytransferservice.service.MoneyTransferService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TransferControllerTest {

    @Mock
    private MoneyTransferService moneyTransferService;

    @InjectMocks
    private TransferController transferController;

    @Test
    void MoneyTransferTest() {
        Operation operation = mock(Operation.class);
        Response response = mock(Response.class);
        when(operation.getOperationId()).thenReturn(String.valueOf(1));
        String idExpected = "1";

        Response responseActual = transferController.moneyTransfer(operation);

        verify(moneyTransferService).proceedOperation(operation);
        assertNotNull(responseActual);
        assertEquals(idExpected, responseActual.getOperationId());

    }
}
