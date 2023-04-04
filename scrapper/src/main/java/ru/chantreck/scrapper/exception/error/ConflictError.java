package ru.chantreck.scrapper.exception.error;

import org.springframework.http.HttpStatus;
import ru.chantreck.scrapper.exception.ApplicationError;

public class ConflictError extends ApplicationError {
    public ConflictError(String message) {
        super(message, HttpStatus.CONFLICT);
    }
}
