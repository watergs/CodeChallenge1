package com.codeChallenge.codeChallenge.exception;

public class InvalidRoomStatusTransition extends RuntimeException {

    public InvalidRoomStatusTransition(String msg) {
        super(msg);
    }
}
