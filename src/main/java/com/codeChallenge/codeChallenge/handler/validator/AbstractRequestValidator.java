package com.codeChallenge.codeChallenge.handler.validator;

public abstract class AbstractRequestValidator {

    protected final String buildErrorMessage(String cause) {
        return cause;
    }
}
