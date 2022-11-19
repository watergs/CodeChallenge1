package com.codeChallenge.codeChallenge.handler.validator;

public interface RequestValidator<Output, Input> {

    Output validate(Input input);

    Output validate();
}
