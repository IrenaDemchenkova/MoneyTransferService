package ru.irenademchenkova.moneytransferservice.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.irenademchenkova.moneytransferservice.models.Operation;

import java.util.concurrent.atomic.AtomicLong;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class OperationRepositoryTest {
    private OperationRepository operationRepository;

    @BeforeEach
    void setUp(){
        operationRepository = new OperationRepository();
    }

    @Test
    void addOperationToListTest(){
        final Operation operation = mock(Operation.class);
        final Integer operationId = operationRepository.getOperationId().intValue();
        int expectedListSize = 1;

        operationRepository.addOperationToList(operation);
        int actualListSize = operationRepository.getOperationList().size();
        Operation operationActual = operationRepository.getOperationList().get(operationId);


        assertEquals(expectedListSize,actualListSize);
        assertNotNull(operationActual);
        assertEquals(operation, operationActual);
    }

    @AfterEach
    void tearDown(){
        operationRepository = null;
    }
}
