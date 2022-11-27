package com.codeChallenge.codeChallenge.executor;

import com.codeChallenge.codeChallenge.common.enums.Room;
import com.codeChallenge.codeChallenge.common.enums.RoomStatus;

import java.util.List;
import java.util.Optional;

public interface OperationsExecutor {

    Optional<Room> findNearestAvailableRoom();

    void markRoom(Room room, RoomStatus newStatus);

    List<Room> findAllRoomsOfRoomStatus(RoomStatus roomStatus);
}