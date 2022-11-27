package com.codeChallenge.codeChallenge.handler;

public interface InputHandler<Output, Input> {

    // Could have also used Input... as parameter to have just 1 method, but felt overloading would be better
    // as it would eliminate checking how many parameters were passed.
    Output handle(Input input);

    Output handle();
}
