package com.codeChallenge.codeChallenge.handler.impl;

import com.codeChallenge.codeChallenge.handler.AbstractInputHandler;
import com.codeChallenge.codeChallenge.handler.validator.impl.CleanRoomInputValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CleanRoomHandler extends AbstractInputHandler<String, String> {

    @Autowired
    private CleanRoomInputValidator cleanRoomInputValidator;

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

