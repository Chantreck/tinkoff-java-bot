package ru.chantreck.scrapper.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.chantreck.scrapper.dto.request.AddLinkRequest;
import ru.chantreck.scrapper.dto.request.RemoveLinkRequest;
import ru.chantreck.scrapper.dto.response.LinkResponse;
import ru.chantreck.scrapper.dto.response.ListLinksResponse;
import ru.chantreck.scrapper.service.LinkService;

@Tag(name = "Links")
@RestController
@RequestMapping("/links")
@RequiredArgsConstructor
public class LinkController {
    private final LinkService service;

    @GetMapping
    public ListLinksResponse getLinks(@RequestHeader("Tg-Chat-Id") Long chatId) {
        var links = service.getAllLinks(chatId);
        return new ListLinksResponse(
                links.stream().map(link -> new LinkResponse(link.id(), link.url())).toList(),
                links.size()
        );
    }

    @PostMapping
    public LinkResponse addLink(@RequestHeader("Tg-Chat-Id") Long chatId, @RequestBody AddLinkRequest body) {
        var link = service.addLink(body.link());
        return new LinkResponse(link.id(), link.url());
    }

    @DeleteMapping
    public LinkResponse deleteLink(@RequestHeader("Tg-Chat-Id") Long chatId, @RequestBody RemoveLinkRequest body) {
        var link = service.deleteLinkByUri(body.link());
        return new LinkResponse(link.id(), link.url());
    }
}
