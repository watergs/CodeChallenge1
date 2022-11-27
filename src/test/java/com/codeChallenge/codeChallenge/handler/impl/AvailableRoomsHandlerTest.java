package com.codeChallenge.codeChallenge.handler.impl;

import com.codeChallenge.codeChallenge.common.enums.Room;
import com.codeChallenge.codeChallenge.executor.OperationsExecutor;
import com.codeChallenge.codeChallenge.handler.validator.impl.AvailableRoomsInputValidator;
import org.mockito.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class AvailableRoomsHandlerTest {

    @InjectMocks
    @Spy
    private AvailableRoomsHandler spy;

    @Mock
    private AvailableRoomsInputValidator availableRoomsInputValidator;

    @Mock
    private OperationsExecutor operationsExecutor;

    @BeforeMethod
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testValidateInputWithNoParamInput() {
        String test = "test";
        Mockito.when(availableRoomsInputValidator.validate()).thenReturn(test);
        List<String> actual = spy.validateInput();

        Assert.assertEquals(actual.get(0), test, "Validation doesn't match");
        Assert.assertEquals(actual.size(), 1, "Validation size doesn't match");
    }

    @Test
    public void testDoHandleWithNoParamInput() {
        String test = "1A";
        Room room = Room.OneA;
        List<Room> roomList = new ArrayList<>();
        roomList.add(room);
        Mockito.when(operationsExecutor.findAllRoomsOfRoomStatus(Mockito.any())).thenReturn(roomList);
        List<String> actual = spy.doHandle();

        Assert.assertEquals(actual.get(0), test, "DoHandle doesn't match");
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
