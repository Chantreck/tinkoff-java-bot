package ru.chantreck.bot.webclient.scrapper.response;

import java.net.URI;

public record LinkResponse(
        Long id,
        URI url
) {}
