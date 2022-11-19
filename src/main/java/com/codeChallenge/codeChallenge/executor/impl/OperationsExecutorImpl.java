package com.codeChallenge.codeChallenge.executor.impl;

import com.codeChallenge.codeChallenge.common.enums.Room;
import com.codeChallenge.codeChallenge.common.enums.RoomStatus;
import com.codeChallenge.codeChallenge.executor.OperationsExecutor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OperationsExecutorImpl implements OperationsExecutor {

    @Override
    public String findNearestAvailableRoom() {
        return null;
    }

    @Override
    public boolean markRoom(Room room, RoomStatus roomStatus) {
        return false;
    }

    @Override
    public List<Room> findAllRoomsOfRoomStatus(RoomStatus roomStatus) {
        return null;
    }
}
