package org.example.exception;

public class UnableToUpdateProduct extends RuntimeException{
    public UnableToUpdateProduct(String message) {
        super(message);
    }
}
