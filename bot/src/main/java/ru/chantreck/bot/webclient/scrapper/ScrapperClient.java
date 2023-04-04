package ru.chantreck.bot.webclient.scrapper;

import java.net.URI;
import ru.chantreck.bot.webclient.scrapper.response.LinkResponse;
import ru.chantreck.bot.webclient.scrapper.response.ListLinksResponse;

public interface ScrapperClient {
    void registerChat(Long chatId);
    void removeChat(Long chatId);
    ListLinksResponse getTrackedLinks(Long chatId);
    LinkResponse addLink(Long chatId, URI link);
    LinkResponse removeLink(Long chatId, URI link);
}
