package com.codeChallenge.codeChallenge.executor.impl;

import com.codeChallenge.codeChallenge.common.enums.Room;
import com.codeChallenge.codeChallenge.common.enums.RoomStatus;
import com.codeChallenge.codeChallenge.executor.OperationsExecutor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class OperationsExecutorImpl implements OperationsExecutor {

    private static Map<Room, RoomStatus> roomStatusMap;
    private static final RoomStatus AVAILABLE_ROOM_STATUS = RoomStatus.AVAILABLE;

    public OperationsExecutorImpl() {
        roomStatusMap = new LinkedHashMap<>();
        Arrays.stream(Room.values()).forEachOrdered(room -> roomStatusMap.put(room, AVAILABLE_ROOM_STATUS));
    }

    @Override
    public Room findNearestAvailableRoom() {
        Room nearestRoom = roomStatusMap.entrySet().stream()
                .filter(roomRoomStatusEntry -> roomRoomStatusEntry.getValue().equals(AVAILABLE_ROOM_STATUS))
                .map(Map.Entry::getKey)
                .findFirst().get();
        roomStatusMap.put(nearestRoom, RoomStatus.OCCUPIED);
        return nearestRoom;
    }

    @Override
    public void markRoom(Room room, RoomStatus roomStatus) {
        roomStatusMap.put(room, roomStatus);
    }

    @Override
    public Integer findRoomCountOfRoomStatus(RoomStatus roomStatus) {
        return Math.toIntExact(roomStatusMap.values().stream().filter(roomStatus::equals).count());
    }

    @Override
    public List<Room> findAllRoomsOfRoomStatus(RoomStatus roomStatus) {
        return roomStatusMap.entrySet().stream()
                .filter(roomRoomStatusEntry -> roomRoomStatusEntry.getValue().equals(roomStatus))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    @Override
    public List<Room> getAllRooms() {
        return new ArrayList<>(roomStatusMap.keySet());
    }

    @Override
    public RoomStatus findRoomStatus(Room room) {
        return roomStatusMap.get(room);
    }
}
