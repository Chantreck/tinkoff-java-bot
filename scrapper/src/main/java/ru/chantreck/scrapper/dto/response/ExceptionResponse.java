package ru.chantreck.scrapper.dto.response;

import java.util.List;

public record ExceptionResponse(
        String description,
        String code,
        String exceptionName,
        String exceptionMessage,
        List<String> stacktrace
) {
}
