package ru.chantreck.scrapper.webclient.stackoverflow;

import lombok.RequiredArgsConstructor;
import org.springframework.web.reactive.function.client.WebClient;
import ru.chantreck.scrapper.webclient.stackoverflow.dto.StackOverflowResponse;
import ru.chantreck.scrapper.webclient.stackoverflow.dto.StackOverflowQuestionResponse;

@RequiredArgsConstructor
public class StackOverflowClientImpl implements StackOverflowClient {
    private static final String BASE_URL = "https://api.stackexchange.com/2.3";
    private final WebClient client;

    public static StackOverflowClientImpl create() {
        return create(BASE_URL);
    }

    public static StackOverflowClientImpl create(String baseUrl) {
        var webClient = WebClient.create(baseUrl);
        return new StackOverflowClientImpl(webClient);
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
