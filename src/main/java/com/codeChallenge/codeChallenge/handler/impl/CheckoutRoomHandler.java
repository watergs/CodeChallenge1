package com.codeChallenge.codeChallenge.handler.impl;

import com.codeChallenge.codeChallenge.common.enums.Room;
import com.codeChallenge.codeChallenge.common.enums.RoomStatus;
import com.codeChallenge.codeChallenge.executor.OperationsExecutor;
import com.codeChallenge.codeChallenge.handler.AbstractInputHandler;
import com.codeChallenge.codeChallenge.handler.validator.impl.CheckoutRoomInputValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CheckoutRoomHandler extends AbstractInputHandler<String, String> {

    private static final RoomStatus VACANT_ROOM_STATUS = RoomStatus.VACANT;
    private static final String ROOM_CHECKOUT_SUCCESSFUL = "The room checkout was successful.";

    @Autowired
    private CheckoutRoomInputValidator checkoutRoomInputValidator;

    @Autowired
    private OperationsExecutor operationsExecutor;

    @Override
    protected String validateInput(String input) {
        return checkoutRoomInputValidator.validate(input);
    }

    @Override
    protected String doHandle(String input) {
        Room room = Room.getEnumFromPersistentValue(input);
        operationsExecutor.markRoom(room, VACANT_ROOM_STATUS);
        return ROOM_CHECKOUT_SUCCESSFUL;
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
