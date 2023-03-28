package ru.chantreck.scrapper.exception;

import org.springframework.http.HttpStatus;

public abstract class ApplicationError extends RuntimeException {
    protected String name = this.getClass().getSimpleName();
    protected HttpStatus code;

    protected ApplicationError(String message, HttpStatus code) {
        super(message);
        this.code = code;
    }
}
