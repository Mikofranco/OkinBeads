package org.example.exception;

public class InvalidUserId extends RuntimeException{
    public InvalidUserId(String message) {
        super(message);
    }
}
