package com.codeChallenge.codeChallenge.handler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractInputHandler<Input> implements InputHandler<Input> {

    public String handle(Input input) {
        logInput(input);
        validateInput(input);
        return doHandle(input);
    }

    protected abstract void validateInput(Input input);

    protected void logInput(Input input){
        log.info("Input: ", input);
    }

    protected abstract String doHandle(Input input);

}
