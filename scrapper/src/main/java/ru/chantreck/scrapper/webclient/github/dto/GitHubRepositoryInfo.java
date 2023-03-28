package ru.chantreck.scrapper.webclient.github.dto;

public record GitHubRepositoryInfo(
        String owner,
        String repository
) {
}
