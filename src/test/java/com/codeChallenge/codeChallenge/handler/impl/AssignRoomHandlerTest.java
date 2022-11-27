package com.codeChallenge.codeChallenge.handler.impl;

import com.codeChallenge.codeChallenge.common.enums.Room;
import com.codeChallenge.codeChallenge.executor.OperationsExecutor;
import com.codeChallenge.codeChallenge.handler.validator.impl.AssignRoomInputValidator;
import org.mockito.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Optional;

public class AssignRoomHandlerTest {

    @InjectMocks
    @Spy
    private AssignRoomHandler spy;

    @Mock
    private AssignRoomInputValidator assignRoomInputValidator;

    @Mock
    private OperationsExecutor operationsExecutor;

    @BeforeMethod
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testValidateInputWithNoParamInput() {
        String test = "test";
        Mockito.when(assignRoomInputValidator.validate()).thenReturn(test);
        String actual = spy.validateInput();

        Assert.assertEquals(actual, test, "Validation doesn't match");
    }

    @Test
    public void testDoHandleWithNoParamInput() {
        String test = "1A";
        Room room = Room.OneA;
        Mockito.when(operationsExecutor.findNearestAvailableRoom()).thenReturn(Optional.of(room));
        String actual = spy.doHandle();

        Assert.assertEquals(actual, test+" has been assigned.", "DoHandle doesn't match");
    }

    @Test
    public void testValidateInput() {
        Assert.assertNull(spy.validateInput(Mockito.anyString()));
    }

    @Test
    public void testDoHandle() {
        Assert.assertNull(spy.doHandle(Mockito.anyString()));
    }
}
