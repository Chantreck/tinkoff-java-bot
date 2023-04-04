package ru.chantreck.scrapper.webclient.github;

import org.springframework.web.reactive.function.client.WebClient;
import ru.chantreck.scrapper.webclient.github.dto.GitHubRepositoryInfo;
import ru.chantreck.scrapper.webclient.github.dto.GitHubRepositoryResponse;

public class GitHubClientImpl implements GitHubClient {
    private static final String DEFAULT_BASE_URL = "https://api.github.com";
    private final WebClient client;

    public GitHubClientImpl() {
        this(DEFAULT_BASE_URL);
    }

    public GitHubClientImpl(String baseUrl) {
        client = WebClient.create(baseUrl);
    }

    public GitHubRepositoryResponse getRepository(GitHubRepositoryInfo info) {
        return client.get()
                .uri(uriBuilder -> uriBuilder.path("/repos/{owner}/{repo}").build(info.owner(), info.repository()))
                .retrieve()
                .bodyToMono(GitHubRepositoryResponse.class)
                .block();
    }
}
