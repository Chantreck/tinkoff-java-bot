package ru.chantreck.scrapper.dto.request;

import java.net.URI;

public record RemoveLinkRequest(
        URI link
) {
}
