package ru.chantreck.scrapper.exception.error.notfound;

import ru.chantreck.scrapper.exception.error.NotFoundError;

public class ChatNotFound extends NotFoundError {
    public ChatNotFound() {
        super("Чат не существует");
    }
}
