package ru.chantreck.scrapper.service.model;

import java.net.URI;

public record Link(
        Long id,
        URI url
) {
}
