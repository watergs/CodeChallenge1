package com.codeChallenge.codeChallenge.client.impl;

import com.codeChallenge.codeChallenge.handler.impl.*;
import org.mockito.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

public class ClientOperationsImplTest {
    
    @InjectMocks
    @Spy
    private ClientOperationsImpl spy;

    @Mock
    private AssignRoomHandler assignRoomHandler;

    @Mock
    private CheckoutRoomHandler checkoutRoomHandler;

    @Mock
    private CleanRoomHandler cleanRoomHandler;

    @Mock
    private RepairRoomHandler repairRoomHandler;

    @Mock
    private AvailableRoomsHandler availableRoomsHandler;

    @BeforeMethod
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAssignRoom() {
        String dummyResponse = "Test";
        Mockito.when(assignRoomHandler.handle()).thenReturn(dummyResponse);
        String actualResponse = spy.assignRoom();
        Assert.assertEquals(actualResponse, dummyResponse, "Response doesn't match");
    }

    @Test
    public void testCheckoutRoom() {
        String dummyResponse = "Test";
        Mockito.when(checkoutRoomHandler.handle(Mockito.anyString())).thenReturn(dummyResponse);
        String actualResponse = spy.checkoutRoom(dummyResponse);
        Assert.assertEquals(actualResponse, dummyResponse, "Response doesn't match");
    }

    @Test
    public void testCleanRoom() {
        String dummyResponse = "Test";
        Mockito.when(cleanRoomHandler.handle(Mockito.anyString())).thenReturn(dummyResponse);
        String actualResponse = spy.cleanRoom(dummyResponse);
        Assert.assertEquals(actualResponse, dummyResponse, "Response doesn't match");
    }

    @Test
    public void testRepairRoom() {
        String dummyResponse = "Test";
        Mockito.when(repairRoomHandler.handle(Mockito.anyString())).thenReturn(dummyResponse);
        String actualResponse = spy.repairRoom(dummyResponse);
        Assert.assertEquals(actualResponse, dummyResponse, "Response doesn't match");
    }

    @Test
    public void testListAvailableRooms() {
        String dummyResponse = "Test";
        List<String> dummyInput = Collections.singletonList(dummyResponse);
        Mockito.when(availableRoomsHandler.handle()).thenReturn(dummyInput);
        List<String> actualResponse = spy.listAvailableRooms();
        Assert.assertEquals(actualResponse, dummyInput, "Response doesn't match");
    }
}
