package ru.chantreck.bot.webclient.scrapper.request;

import java.net.URI;

public record RemoveLinkRequest(
        URI link
) {}
