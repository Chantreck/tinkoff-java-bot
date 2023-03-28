package ru.chantreck.scrapper.exception.error.not_found;

import ru.chantreck.scrapper.exception.error.NotFoundError;

public class LinkNotFoundError extends NotFoundError {

    public LinkNotFoundError() {
        super("Ссылка не найдена");
    }
}
