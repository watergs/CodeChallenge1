package com.codeChallenge.codeChallenge.handler.impl;

import com.codeChallenge.codeChallenge.common.enums.Room;
import com.codeChallenge.codeChallenge.common.enums.RoomStatus;
import com.codeChallenge.codeChallenge.executor.OperationsExecutor;
import com.codeChallenge.codeChallenge.handler.AbstractInputHandler;
import com.codeChallenge.codeChallenge.handler.validator.impl.AssignRoomInputValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static com.codeChallenge.codeChallenge.handler.validator.impl.ErrorMessages.NO_ROOMS_AVAILABLE;

@Component
public class AssignRoomHandler extends AbstractInputHandler<String, String> {

    private static String HAS_BEEN_ASSIGNED = " has been assigned.";

    @Autowired
    private AssignRoomInputValidator assignRoomInputValidator;

    @Autowired
    private OperationsExecutor operationsExecutor;

    @Override
    protected String validateInput() {
        return assignRoomInputValidator.validate();
    }

    @Override
    protected String doHandle() {
        Optional<Room> roomOptional = operationsExecutor.findNearestAvailableRoom();
        if(roomOptional.isPresent()) {
            operationsExecutor.markRoom(roomOptional.get(), RoomStatus.OCCUPIED);
            return roomOptional.get().getRoom() + HAS_BEEN_ASSIGNED;
        }
        return NO_ROOMS_AVAILABLE;
    }

    @Override
    protected String validateInput(String input) {
        return null;
    }

    @Override
    protected String doHandle(String input) {
        return null;
    }
}
