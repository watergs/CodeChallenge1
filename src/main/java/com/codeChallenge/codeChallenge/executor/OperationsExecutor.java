package com.codeChallenge.codeChallenge.executor;

import com.codeChallenge.codeChallenge.common.enums.Room;
import com.codeChallenge.codeChallenge.common.enums.RoomStatus;

import java.util.List;

public interface OperationsExecutor {

    String findNearestAvailableRoom();

    boolean markRoom(Room room, RoomStatus roomStatus);

    List<Room> findAllRoomsOfRoomStatus(RoomStatus roomStatus);
}
