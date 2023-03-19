package ru.chantreck.parser;

import ru.chantreck.parser.response.EmptyResponse;
import ru.chantreck.parser.response.LinkParserResponse;

public abstract class LinkParser {
    private final LinkParser nextParser;

    protected LinkParser(LinkParser nextParser) {
        this.nextParser = nextParser;
    }

    public LinkParserResponse parseLink(Link link) {
        if (nextParser != null) {
            return nextParser.parseLink(link);
        } else {
            return new EmptyResponse();
        }
    }
}
