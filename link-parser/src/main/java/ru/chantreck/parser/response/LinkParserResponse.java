package ru.chantreck.parser.response;

public sealed interface LinkParserResponse permits EmptyResponse, GitHubResponse, StackOverflowResponse {
}
