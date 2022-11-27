package com.codeChallenge.codeChallenge.executor.impl;

import com.codeChallenge.codeChallenge.common.enums.Room;
import com.codeChallenge.codeChallenge.common.enums.RoomStatus;
import com.codeChallenge.codeChallenge.exception.InvalidRoomStatusTransition;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.test.util.ReflectionTestUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class OperationsExecutorImplImplTest {

    @InjectMocks
    @Spy
    private OperationsExecutorImpl spy;

    @BeforeMethod
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindNearestAvailableRoom() {
        Room expected = Room.OneA;
        Optional<Room> actual = spy.findNearestAvailableRoom();

        Assert.assertEquals(actual.get(), expected, "Room doesn't match.");
    }

    @Test(expectedExceptions = InvalidRoomStatusTransition.class)
    public void testMarkRoomWithError() {
        Room room = Room.OneC;
        RoomStatus roomStatus = RoomStatus.VACANT;
        spy.markRoom(room, roomStatus);
        Map<Room, RoomStatus> fetchedMap = (Map<Room, RoomStatus>) ReflectionTestUtils.getField(spy, "roomStatusMap");

        Assert.assertEquals(fetchedMap.get(room), roomStatus, "RoomStatus doesn't match");
    }

    @Test
    public void testMarkRoom() {
        Room room = Room.OneA;
        RoomStatus roomStatus = RoomStatus.OCCUPIED;
        spy.markRoom(room, roomStatus);
        Map<Room, RoomStatus> fetchedMap = (Map<Room, RoomStatus>) ReflectionTestUtils.getField(spy, "roomStatusMap");

        Assert.assertEquals(fetchedMap.get(room), roomStatus, "RoomStatus doesn't match");
    }

    @Test
    public void testFindAllRoomsOfRoomStatus() {
        List<Room> expectedRooms = spy.findAllRoomsOfRoomStatus(RoomStatus.AVAILABLE);
        Assert.assertEquals(expectedRooms.size(), 20, "Total available Rooms don't match");
    }
}
