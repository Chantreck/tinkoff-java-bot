package ru.chantreck.scrapper.webclient.github;

import lombok.RequiredArgsConstructor;
import org.springframework.web.reactive.function.client.WebClient;
import ru.chantreck.scrapper.webclient.github.dto.GitHubRepositoryInfo;
import ru.chantreck.scrapper.webclient.github.dto.GitHubRepositoryResponse;

@RequiredArgsConstructor
public class GitHubClientImpl implements GitHubClient {
    private static final String BASE_URL = "https://api.github.com";
    private final WebClient client;

    public static GitHubClientImpl create() {
        return create(BASE_URL);
    }

    public static GitHubClientImpl create(String baseUrl) {
        var webClient = WebClient.create(baseUrl);
        return new GitHubClientImpl(webClient);
    }

    public GitHubRepositoryResponse getRepository(GitHubRepositoryInfo info) {
        return client.get()
                .uri(uriBuilder -> uriBuilder.path("/repos/{owner}/{repo}").build(info.owner(), info.repository()))
                .retrieve()
                .bodyToMono(GitHubRepositoryResponse.class)
                .block();
    }
}
