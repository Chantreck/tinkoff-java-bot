package ru.chantreck.parser.response;

public record GitHubResponse(
        String user,
        String repository
) implements LinkParserResponse {
}
