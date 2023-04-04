package ru.chantreck.scrapper.webclient.stackoverflow.dto;

import java.util.List;

public record StackOverflowResponse(
        List<StackOverflowQuestionResponse> items
) {
}
