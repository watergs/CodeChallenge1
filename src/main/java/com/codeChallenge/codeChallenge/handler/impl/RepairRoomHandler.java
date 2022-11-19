package com.codeChallenge.codeChallenge.handler.impl;

import com.codeChallenge.codeChallenge.handler.AbstractInputHandler;
import com.codeChallenge.codeChallenge.handler.validator.impl.RepairRoomInputValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RepairRoomHandler extends AbstractInputHandler<String, String> {
    
    @Autowired
    private RepairRoomInputValidator repairRoomInputValidator;

    @Override
    protected String validateInput(String input) {
        return null;
    }

    @Override
    protected String doHandle(String input) {
        return null;
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
