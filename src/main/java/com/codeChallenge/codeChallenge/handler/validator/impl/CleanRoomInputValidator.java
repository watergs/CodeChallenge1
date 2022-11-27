package com.codeChallenge.codeChallenge.handler.validator.impl;

import com.codeChallenge.codeChallenge.common.enums.Room;
import com.codeChallenge.codeChallenge.handler.validator.AbstractRequestValidator;
import com.codeChallenge.codeChallenge.handler.validator.RequestValidator;
import org.springframework.stereotype.Component;

import static com.codeChallenge.codeChallenge.handler.validator.impl.ErrorMessages.INVALID_INPUT;

@Component
public class CleanRoomInputValidator extends AbstractRequestValidator implements RequestValidator<String, String> {

    @Override
    public String validate(String input) {
        String validationError;
        Room room = Room.getEnumFromPersistentValue(input);
        if(room == null) {
            validationError = INVALID_INPUT;
            return validationError;
        }
        return null;
    }

    @Override
    public String validate() {
        return null;
    }
}
