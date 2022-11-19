package com.codeChallenge.codeChallenge.handler;

public interface InputHandler<Output, Input> {

    Output handle(Input input);

    Output handle();
}
