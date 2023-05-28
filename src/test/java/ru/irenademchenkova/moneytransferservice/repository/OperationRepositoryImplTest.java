package ru.irenademchenkova.moneytransferservice.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.irenademchenkova.moneytransferservice.models.Operation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

public class OperationRepositoryImplTest {
    private OperationRepositoryImpl operationRepositoryImpl;

    @BeforeEach
    void setUp() {
        operationRepositoryImpl = new OperationRepositoryImpl();
    }

    @Test
    void addOperationToListTest() {
        final Operation operation = mock(Operation.class);
        final Integer operationId = operationRepositoryImpl.getOperationId().intValue();
        int expectedListSize = 1;

        operationRepositoryImpl.addOperationToList(operation);
        int actualListSize = operationRepositoryImpl.getOperationList().size();
        Operation operationActual = operationRepositoryImpl.getOperationList().get(operationId);

        assertEquals(expectedListSize, actualListSize);
        assertNotNull(operationActual);
        assertEquals(operation, operationActual);
    }

    @AfterEach
    void tearDown() {
        operationRepositoryImpl = null;
    }
}
