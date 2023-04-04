package ru.chantreck.scrapper.exception.error;

import org.springframework.http.HttpStatus;
import ru.chantreck.scrapper.exception.ApplicationError;

public class NotFoundError extends ApplicationError {
    public NotFoundError(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
