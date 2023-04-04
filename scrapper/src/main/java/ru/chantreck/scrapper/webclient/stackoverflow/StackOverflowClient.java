package ru.chantreck.scrapper.webclient.stackoverflow;

import ru.chantreck.scrapper.webclient.stackoverflow.dto.StackOverflowQuestionResponse;

public interface StackOverflowClient {
    StackOverflowQuestionResponse getQuestionById(int questionId);
}
