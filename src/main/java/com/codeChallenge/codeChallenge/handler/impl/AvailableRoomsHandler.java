package com.codeChallenge.codeChallenge.handler.impl;

import com.codeChallenge.codeChallenge.handler.AbstractInputHandler;
import com.codeChallenge.codeChallenge.handler.validator.impl.AvailableRoomsInputValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AvailableRoomsHandler extends AbstractInputHandler<List<String>, String> {

    @Autowired
    private AvailableRoomsInputValidator availableRoomsInputValidator;

    @Override
    protected List<String> validateInput(String s) {
        return null;
    }

    @Override
    protected List<String> validateInput() {
        return null;
    }

    @Override
    protected List<String> doHandle(String s) {
        return null;
    }

    @Override
    protected List<String> doHandle() {
        return null;
    }
}
