package ru.chantreck.bot.webclient.scrapper.response;

import java.util.List;

public record ListLinksResponse(
        List<LinkResponse> links,
        int size
) {}
