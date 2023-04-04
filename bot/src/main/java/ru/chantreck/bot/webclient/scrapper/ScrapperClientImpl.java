package ru.chantreck.bot.webclient.scrapper;

import java.net.URI;
import org.springframework.http.HttpMethod;
import org.springframework.web.reactive.function.client.WebClient;
import ru.chantreck.bot.webclient.scrapper.request.AddLinkRequest;
import ru.chantreck.bot.webclient.scrapper.request.RemoveLinkRequest;
import ru.chantreck.bot.webclient.scrapper.response.LinkResponse;
import ru.chantreck.bot.webclient.scrapper.response.ListLinksResponse;

public class ScrapperClientImpl implements ScrapperClient {
    private static final String HEADER_TG_CHAT_ID = "Tg-Chat-Id";
    private final WebClient client;

    public ScrapperClientImpl(String baseUrl) {
        client = WebClient.create(baseUrl);
    }

    public void registerChat(Long chatId) {
        client.post()
                .uri(uriBuilder -> uriBuilder.path("/tg-chat/{id}").build(chatId))
                .retrieve()
                .bodyToMono(LinkResponse.class)
                .block();
    }

    public void removeChat(Long chatId) {
        client.method(HttpMethod.DELETE)
                .uri(uriBuilder -> uriBuilder.path("/tg-chat/{id}").build(chatId))
                .retrieve()
                .bodyToMono(LinkResponse.class)
                .block();
    }

    public ListLinksResponse getTrackedLinks(Long chatId) {
        return client.get()
                .uri("/links")
                .header(HEADER_TG_CHAT_ID, chatId.toString())
                .retrieve()
                .bodyToMono(ListLinksResponse.class)
                .block();
    }

    public LinkResponse addLink(Long chatId, URI link) {
        var body = new AddLinkRequest(link);
        return client.post()
                .uri("/links")
                .header(HEADER_TG_CHAT_ID, chatId.toString())
                .bodyValue(body)
                .retrieve()
                .bodyToMono(LinkResponse.class)
                .block();
    }

    public LinkResponse removeLink(Long chatId, URI link) {
        var body = new RemoveLinkRequest(link);
        return client.method(HttpMethod.DELETE)
                .uri("/links")
                .header(HEADER_TG_CHAT_ID, chatId.toString())
                .bodyValue(body)
                .retrieve()
                .bodyToMono(LinkResponse.class)
                .block();
    }
}
