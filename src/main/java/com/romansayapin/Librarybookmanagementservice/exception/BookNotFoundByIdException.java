package com.romansayapin.Librarybookmanagementservice.exception;

public class BookNotFoundByIdException extends RuntimeException{
    public BookNotFoundByIdException(String message) {
        super(message);
    }
}
