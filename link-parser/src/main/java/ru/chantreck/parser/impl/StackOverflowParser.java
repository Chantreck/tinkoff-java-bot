package ru.chantreck.parser.impl;

import java.util.regex.Pattern;
import ru.chantreck.parser.Link;
import ru.chantreck.parser.LinkParser;
import ru.chantreck.parser.response.LinkParserResponse;
import ru.chantreck.parser.response.StackOverflowResponse;

public class StackOverflowParser extends LinkParser {
    public StackOverflowParser(LinkParser nextParser) {
        super(nextParser);
    }

    @Override
    public LinkParserResponse parseLink(Link link) {
        if (!isAcceptable(link)) {
            return super.parseLink(link);
        }

        var matcher = pattern.matcher(link.link());
        if (matcher.find()) {
            var id = Integer.parseInt(matcher.group(1));
            return new StackOverflowResponse(id);
        }

        return super.parseLink(link);
    }

    private boolean isAcceptable(Link link) {
        return Pattern.matches(TEMPLATE, link.link());
    }

    private final static String STACK_OVERFLOW_URL = "stackoverflow.com";
    private final static String ID_TEMPLATE = "\\d+";
    private final static String TEMPLATE = String.format(".*%s/questions/(%s).*", STACK_OVERFLOW_URL, ID_TEMPLATE);
    private final static Pattern pattern = Pattern.compile(TEMPLATE);
}
