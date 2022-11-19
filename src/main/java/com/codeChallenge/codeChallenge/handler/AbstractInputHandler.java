package com.codeChallenge.codeChallenge.handler;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

@Slf4j
public abstract class AbstractInputHandler<Output, Input> implements InputHandler<Output, Input> {

    public Output handle(Input input) {
        logInput(input);
        Output validationError = validateInput(input);
        if(validationError != null) {
            return validationError;
        }
        return doHandle(input);
    }

    public Output handle() {
        Input input = null;
        logInput(input);
        Output validationError = validateInput(input);
        if(validationError != null) {
            return validationError;
        }
        return doHandle(input);
    }

    protected abstract Output validateInput(Input input);

    protected abstract Output validateInput();

    protected void logInput(Input input){
        if (input == null) {
            log.info("No input detected");
        } else {
            log.info("Input: ", input);
        }
    }

    protected abstract Output doHandle(Input input);

    protected abstract Output doHandle();

}
