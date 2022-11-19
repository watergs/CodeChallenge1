package com.codeChallenge.codeChallenge.handler.impl;

import com.codeChallenge.codeChallenge.common.enums.Room;
import com.codeChallenge.codeChallenge.common.enums.RoomStatus;
import com.codeChallenge.codeChallenge.executor.OperationsExecutor;
import com.codeChallenge.codeChallenge.handler.AbstractInputHandler;
import com.codeChallenge.codeChallenge.handler.validator.impl.CleanRoomInputValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CleanRoomHandler extends AbstractInputHandler<String, String> {

    private static final RoomStatus AVAILABLE_ROOM_STATUS = RoomStatus.AVAILABLE;
    private static final String ROOM_CLEANING_SUCCESSFUL = "The room cleaning was successful.";

    @Autowired
    private CleanRoomInputValidator cleanRoomInputValidator;

    @Autowired
    private OperationsExecutor operationsExecutor;

    @Override
    protected String validateInput(String input) {
        return cleanRoomInputValidator.validate(input);
    }

    @Override
    protected String doHandle(String input) {
        Room room = Room.getEnumFromPersistentValue(input);
        operationsExecutor.markRoom(room, AVAILABLE_ROOM_STATUS);
        return ROOM_CLEANING_SUCCESSFUL;
    }

    @Override
    protected String validateInput() {
        return null;
    }

    @Override
    protected String doHandle() {
        return null;
    }
}

