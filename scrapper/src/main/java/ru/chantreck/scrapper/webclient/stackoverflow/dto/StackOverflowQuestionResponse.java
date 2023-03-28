package ru.chantreck.scrapper.webclient.stackoverflow.dto;

import java.time.OffsetDateTime;

public record StackOverflowQuestionResponse(
        OffsetDateTime updatedAt
) {
}
