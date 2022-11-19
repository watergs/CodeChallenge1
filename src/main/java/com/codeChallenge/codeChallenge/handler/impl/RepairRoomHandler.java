package com.codeChallenge.codeChallenge.handler.impl;

import com.codeChallenge.codeChallenge.common.enums.Room;
import com.codeChallenge.codeChallenge.common.enums.RoomStatus;
import com.codeChallenge.codeChallenge.executor.OperationsExecutor;
import com.codeChallenge.codeChallenge.handler.AbstractInputHandler;
import com.codeChallenge.codeChallenge.handler.validator.impl.RepairRoomInputValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RepairRoomHandler extends AbstractInputHandler<String, String> {

    private static final RoomStatus REPAIR_ROOM_STATUS = RoomStatus.REPAIR;
    private static final String ROOM_REPAIRING_SUCCESSFUL = "The room repairing was successful.";
    
    @Autowired
    private RepairRoomInputValidator repairRoomInputValidator;

    @Autowired
    private OperationsExecutor operationsExecutor;

    @Override
    protected String validateInput(String input) {
        return repairRoomInputValidator.validate(input);
    }

    @Override
    protected String doHandle(String input) {
        Room room = Room.getEnumFromPersistentValue(input);
        operationsExecutor.markRoom(room, REPAIR_ROOM_STATUS);
        return ROOM_REPAIRING_SUCCESSFUL;
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
