package ru.chantreck.scrapper.webclient.github;

import ru.chantreck.scrapper.webclient.github.dto.GitHubRepositoryInfo;
import ru.chantreck.scrapper.webclient.github.dto.GitHubRepositoryResponse;

public interface GitHubClient {
    GitHubRepositoryResponse getRepository(GitHubRepositoryInfo info);
}
