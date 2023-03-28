package ru.chantreck.bot.exception;

import java.util.Arrays;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.chantreck.bot.dto.response.ExceptionResponse;
import ru.chantreck.bot.exception.error.BadRequestError;

@RestControllerAdvice
public class DefaultExceptionHandler {
    @ExceptionHandler(BadRequestError.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionResponse handleBadRequestError(BadRequestError error) {
        return toResponse(error);
    }

    @ExceptionHandler(ApplicationError.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionResponse handleApplicationError(ApplicationError error) {
        return toResponse(error);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionResponse handleException(Exception error) {
        return new ExceptionResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                HttpStatus.INTERNAL_SERVER_ERROR.name(),
                error.getClass().getSimpleName(),
                error.getMessage(),
                Arrays.stream(error.getStackTrace()).map(StackTraceElement::toString).toList()
        );
    }

    private ExceptionResponse toResponse(ApplicationError error) {
        return new ExceptionResponse(
                error.code.getReasonPhrase(),
                error.code.name(),
                error.name,
                error.getMessage(),
                Arrays.stream(error.getStackTrace()).map(StackTraceElement::toString).toList()
        );
    }
}
