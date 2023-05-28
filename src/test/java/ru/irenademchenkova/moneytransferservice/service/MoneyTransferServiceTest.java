package ru.irenademchenkova.moneytransferservice.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.irenademchenkova.moneytransferservice.models.Operation;
import ru.irenademchenkova.moneytransferservice.repository.OperationRepositoryImpl;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class MoneyTransferServiceTest {
    @Mock
    private OperationRepositoryImpl operationRepositoryImpl;
    @InjectMocks
    private MoneyTransferServiceImpl moneyTransferService;

    @Test
    void proceedOperationTest() {
        final Operation operation = mock(Operation.class);
        moneyTransferService.proceedOperation(operation);
        verify(operationRepositoryImpl).addOperationToList(operation);
    }
}
