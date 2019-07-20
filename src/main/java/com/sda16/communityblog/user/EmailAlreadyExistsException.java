package com.sda16.communityblog.user;

public class EmailAlreadyExistsException extends Exception {

    public EmailAlreadyExistsException(String message) {
        super(message);
    }
}
