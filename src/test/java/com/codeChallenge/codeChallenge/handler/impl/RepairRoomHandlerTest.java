package com.codeChallenge.codeChallenge.handler.impl;

import com.codeChallenge.codeChallenge.executor.OperationsExecutor;
import com.codeChallenge.codeChallenge.handler.validator.impl.RepairRoomInputValidator;
import org.mockito.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RepairRoomHandlerTest {

    @InjectMocks
    @Spy
    private RepairRoomHandler spy;

    @Mock
    private RepairRoomInputValidator repairRoomInputValidator;

    @Mock
    private OperationsExecutor operationsExecutor;

    @BeforeMethod
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testValidateInput() {
        String test = "test";
        Mockito.when(repairRoomInputValidator.validate(Mockito.anyString())).thenReturn(test);
        String actual = spy.validateInput(Mockito.anyString());

        Assert.assertEquals(actual, test, "Validation doesn't match");
    }

    @Test
    public void testDoHandle() {
        String actual = spy.doHandle(Mockito.anyString());
        Mockito.verify(operationsExecutor, Mockito.atLeastOnce()).markRoom(Mockito.any(), Mockito.any());
        Assert.assertNotNull(actual, "DoHandle doesn't work");
    }

    @Test
    public void testValidateWithNoParamInput() {
        Assert.assertNull(spy.validateInput());
    }

    @Test
    public void testDoHandleWithNoParamInput() {
        Assert.assertNull(spy.doHandle());
    }
}
