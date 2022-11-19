package com.codeChallenge.codeChallenge.handler.impl;

import com.codeChallenge.codeChallenge.executor.OperationsExecutor;
import com.codeChallenge.codeChallenge.handler.AbstractInputHandler;
import com.codeChallenge.codeChallenge.handler.validator.impl.AssignRoomInputValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AssignRoomHandler extends AbstractInputHandler<String, String> {

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
        return operationsExecutor.findNearestAvailableRoom().getRoom();
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
