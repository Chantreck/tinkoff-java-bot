package ru.chantreck.scrapper.webclient.stackoverflow;

import lombok.RequiredArgsConstructor;
import org.springframework.web.reactive.function.client.WebClient;
import ru.chantreck.scrapper.webclient.stackoverflow.dto.StackOverflowResponse;
import ru.chantreck.scrapper.webclient.stackoverflow.dto.StackOverflowQuestionResponse;

@RequiredArgsConstructor
public class StackOverflowClientImpl implements StackOverflowClient {
    private static final String DEFAULT_BASE_URL = "https://api.stackexchange.com/2.3";
    private final WebClient client;

    public StackOverflowClientImpl() {
        this(DEFAULT_BASE_URL);
    }

    public StackOverflowClientImpl(String baseUrl) {
        client = WebClient.create(baseUrl);
    }

    @Override
    public StackOverflowQuestionResponse getQuestionById(int questionId) {
        var response = client.get()
                .uri(uriBuilder -> uriBuilder.path("/questions/{id}?site=stackoverflow").build(questionId))
                .retrieve()
                .bodyToMono(StackOverflowResponse.class)
                .block();
        return response.items().get(0);
    }
}
