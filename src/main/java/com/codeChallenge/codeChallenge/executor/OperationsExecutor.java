package com.codeChallenge.codeChallenge.executor;

import com.codeChallenge.codeChallenge.common.enums.Room;
import com.codeChallenge.codeChallenge.common.enums.RoomStatus;

import java.util.List;

public interface OperationsExecutor {

    Room findNearestAvailableRoom();

    RoomStatus findRoomStatus(Room room);

    void markRoom(Room room, RoomStatus roomStatus);

    Integer findRoomCountOfRoomStatus(RoomStatus roomStatus);

    List<Room> findAllRoomsOfRoomStatus(RoomStatus roomStatus);

    List<Room> getAllRooms();


}
