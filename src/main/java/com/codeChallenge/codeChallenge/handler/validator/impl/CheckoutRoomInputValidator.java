package com.codeChallenge.codeChallenge.handler.validator.impl;

import com.codeChallenge.codeChallenge.common.enums.Room;
import com.codeChallenge.codeChallenge.common.enums.RoomStatus;
import com.codeChallenge.codeChallenge.executor.OperationsExecutor;
import com.codeChallenge.codeChallenge.handler.validator.AbstractRequestValidator;
import com.codeChallenge.codeChallenge.handler.validator.RequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.codeChallenge.codeChallenge.handler.validator.impl.ErrorMessages.INVALID_INPUT;
import static com.codeChallenge.codeChallenge.handler.validator.impl.ErrorMessages.ROOM_STATUS;

@Component
public class CheckoutRoomInputValidator extends AbstractRequestValidator implements RequestValidator<String, String> {

    @Autowired
    private OperationsExecutor operationsExecutor;

    @Override
    public String validate(String input) {
        String validationError = null;
        Room room = Room.getEnumFromPersistentValue(input);
        RoomStatus roomStatus = operationsExecutor.findRoomStatus(room);

        if(room == null) {
            validationError = buildErrorMessage(INVALID_INPUT);
        } else if(roomStatus != RoomStatus.OCCUPIED) {
            validationError = buildErrorMessage(ROOM_STATUS + roomStatus);
        }
        return validationError;
    }

    @Override
    public String validate() {
        return null;
    }
}
