package com.codeChallenge.codeChallenge.handler.validator.impl;

import com.codeChallenge.codeChallenge.common.enums.RoomStatus;
import com.codeChallenge.codeChallenge.executor.OperationsExecutor;
import com.codeChallenge.codeChallenge.handler.validator.AbstractRequestValidator;
import com.codeChallenge.codeChallenge.handler.validator.RequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static com.codeChallenge.codeChallenge.handler.validator.impl.ErrorMessages.NO_ROOMS_AVAILABLE;

@Component
public class AvailableRoomsInputValidator extends AbstractRequestValidator implements RequestValidator {

    private static final RoomStatus AVAILABLE_ROOM_STATUS = RoomStatus.AVAILABLE;

    @Autowired
    private OperationsExecutor operationsExecutor;

    @Override
    public String validate() {
        String validationError = null;

        Integer availableRoomCount = operationsExecutor.findRoomCountOfRoomStatus(AVAILABLE_ROOM_STATUS);
        if(!Optional.ofNullable(availableRoomCount).isPresent() || availableRoomCount == 0) {
            validationError = NO_ROOMS_AVAILABLE;
        }

        return validationError;
    }

    @Override
    public Object validate(Object o) {
        return null;
    }
}
