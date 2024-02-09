package org.example.exception;

public class UnableToDelete extends RuntimeException{
    public UnableToDelete(String message) {
        super(message);
    }
}
