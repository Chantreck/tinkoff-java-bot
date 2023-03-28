package ru.chantreck.scrapper.exception;

import java.util.Arrays;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.chantreck.scrapper.dto.response.ExceptionResponse;
import ru.chantreck.scrapper.exception.error.BadRequestError;
import ru.chantreck.scrapper.exception.error.ConflictError;
import ru.chantreck.scrapper.exception.error.NotFoundError;

@RestControllerAdvice
public class DefaultExceptionHandler {
    @ExceptionHandler(BadRequestError.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionResponse handleBadRequestError(BadRequestError error) {
        return toResponse(error);
    }

    @ExceptionHandler(NotFoundError.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse handleNotFoundError(NotFoundError error) {
        return toResponse(error);
    }

    @ExceptionHandler(ConflictError.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ExceptionResponse handleConflict(ConflictError error) {
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
