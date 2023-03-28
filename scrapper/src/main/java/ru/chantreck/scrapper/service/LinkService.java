package ru.chantreck.scrapper.service;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import ru.chantreck.scrapper.exception.error.ConflictError;
import ru.chantreck.scrapper.exception.error.notfound.LinkNotFoundError;
import ru.chantreck.scrapper.service.model.Link;

@Service
public class LinkService {
    private List<Link> links = new ArrayList<>();

    public List<Link> getAllLinks(Long chatId) {
        return links;
    }

    public Link addLink(URI url) {
        if (isLinkAlreadyAdded(url)) {
            throw new ConflictError("Ссылка уже добавлена");
        }

        var link = new Link(links.size() + 1L, url);
        links.add(link);
        return link;
    }

    public Link deleteLinkByUri(URI url) {
        var link = getLinkByUri(url);
        links.remove(link);
        return link;
    }

    private boolean isLinkAlreadyAdded(URI url) {
        return links.stream().anyMatch(it -> it.url().equals(url));
    }

    private Link getLinkByUri(URI url) {
        return links.stream().filter(it -> it.url().equals(url)).findFirst().orElseThrow(LinkNotFoundError::new);
    }
}
