package ru.chantreck.parser.impl;

import java.util.regex.Pattern;
import ru.chantreck.parser.Link;
import ru.chantreck.parser.LinkParser;
import ru.chantreck.parser.response.GitHubResponse;
import ru.chantreck.parser.response.LinkParserResponse;

public class GitHubLinkParser extends LinkParser {
    public GitHubLinkParser(LinkParser nextParser) {
        super(nextParser);
    }

    @Override
    public LinkParserResponse parseLink(Link link) {
        if (!isAcceptable(link)) {
            return super.parseLink(link);
        }

        var matcher = pattern.matcher(link.link());
        if (matcher.find()) {
            var user = matcher.group(1);
            var repository = matcher.group(2);
            return new GitHubResponse(user, repository);
        }

        return super.parseLink(link);
    }

    private boolean isAcceptable(Link link) {
        return Pattern.matches(TEMPLATE, link.link());
    }

    private final static String GITHUB_URL = "github\\.com";
    private final static String USER_TEMPLATE = "[\\w_-]+";
    private final static String REPOSITORY_TEMPLATE = "[\\w_-]+";
    private final static String TEMPLATE = String.format(".*%s/(%s)/(%s).*", GITHUB_URL, USER_TEMPLATE, REPOSITORY_TEMPLATE);
    private final static Pattern pattern = Pattern.compile(TEMPLATE);
}
