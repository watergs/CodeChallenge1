package com.codeChallenge.codeChallenge.executor.impl;

import com.codeChallenge.codeChallenge.common.enums.Room;
import com.codeChallenge.codeChallenge.common.enums.RoomStatus;
import com.codeChallenge.codeChallenge.exception.InvalidRoomStatusTransition;
import com.codeChallenge.codeChallenge.executor.OperationsExecutor;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class OperationsExecutorImpl implements OperationsExecutor {

    private static Map<Room, RoomStatus> roomStatusMap;
    private static final RoomStatus AVAILABLE_ROOM_STATUS = RoomStatus.AVAILABLE;

    public OperationsExecutorImpl() {
        // LinkedHashMap used for maintaining insertion order since the room numbers are fixed.
        roomStatusMap = new LinkedHashMap<>();
        Arrays.stream(Room.values()).forEachOrdered(room -> roomStatusMap.put(room, AVAILABLE_ROOM_STATUS));
    }

    @Override
    public Optional<Room> findNearestAvailableRoom() {
        // If LinkedHashMap were not to be used, you could get the list of Room that were in available state and
        // then get the distance(available in Room enum class) of it to find the smallest distance from door.
        Optional<Room> nearestRoomOptional = roomStatusMap.entrySet().stream()
                .filter(roomRoomStatusEntry -> roomRoomStatusEntry.getValue().equals(AVAILABLE_ROOM_STATUS))
                .map(Map.Entry::getKey)
                .findFirst();

        return nearestRoomOptional;
    }

    @Override
    public void markRoom(Room room, RoomStatus newStatus) {
        RoomStatus previousStatus = roomStatusMap.get(room);

        if(previousStatus == RoomStatus.AVAILABLE && newStatus == RoomStatus.OCCUPIED //Room occupied
                ||previousStatus == RoomStatus.OCCUPIED && newStatus == RoomStatus.VACANT // Room checked out.
                || previousStatus == RoomStatus.VACANT && newStatus == RoomStatus.AVAILABLE // Room cleaned.
                || previousStatus == RoomStatus.VACANT && newStatus == RoomStatus.REPAIR // Room put in repair.
                || previousStatus == RoomStatus.REPAIR && newStatus == RoomStatus.VACANT) { // Room repairing complete.

            roomStatusMap.put(room, newStatus);
            return;
        }
        throw new InvalidRoomStatusTransition("Invalid Room Status Transition");
    }

public List<Room> findAllRoomsOfRoomStatus(RoomStatus roomStatus) {
        return roomStatusMap.entrySet().stream()
                .filter(roomRoomStatusEntry -> roomRoomStatusEntry.getValue().equals(roomStatus))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}
