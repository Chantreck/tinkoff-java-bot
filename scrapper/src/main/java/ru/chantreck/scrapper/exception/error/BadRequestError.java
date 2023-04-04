package ru.chantreck.scrapper.exception.error;

import org.springframework.http.HttpStatus;
import ru.chantreck.scrapper.exception.ApplicationError;

public class BadRequestError extends ApplicationError {
    public BadRequestError() {
        super("Некорректные параметры запуска", HttpStatus.BAD_REQUEST);
    }
}
