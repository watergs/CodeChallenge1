package com.codeChallenge.codeChallenge.handler.impl;

import com.codeChallenge.codeChallenge.common.enums.Room;
import com.codeChallenge.codeChallenge.common.enums.RoomStatus;
import com.codeChallenge.codeChallenge.executor.OperationsExecutor;
import com.codeChallenge.codeChallenge.handler.AbstractInputHandler;
import com.codeChallenge.codeChallenge.handler.validator.impl.AvailableRoomsInputValidator;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AvailableRoomsHandler extends AbstractInputHandler<List<String>, String> {

    private static final RoomStatus AVAILABLE_ROOM_STATUS = RoomStatus.AVAILABLE;

    @Autowired
    private AvailableRoomsInputValidator availableRoomsInputValidator;

    @Autowired
    private OperationsExecutor operationsExecutor;

    @Override
    protected List<String> validateInput() {
        return StringUtils.isNotEmpty(availableRoomsInputValidator.validate()) ?
                Collections.singletonList(availableRoomsInputValidator.validate()) : null;
    }

    @Override
    protected List<String> doHandle() {
        List<Room> availableRooms = operationsExecutor.findAllRoomsOfRoomStatus(AVAILABLE_ROOM_STATUS);
        return availableRooms.stream().map(Room::toString).collect(Collectors.toList());
    }

    @Override
    protected List<String> validateInput(String s) {
        return null;
    }

    @Override
    protected List<String> doHandle(String s) {
        return null;
    }
}
