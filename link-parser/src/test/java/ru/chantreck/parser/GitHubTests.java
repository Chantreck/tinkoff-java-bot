package ru.chantreck.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import ru.chantreck.parser.impl.GitHubLinkParser;
import ru.chantreck.parser.response.EmptyResponse;
import ru.chantreck.parser.response.GitHubResponse;

public class GitHubTests {
    private final GitHubLinkParser parser = new GitHubLinkParser(null);

    @Test
    void testCorrectGitHubLink() {
        var link = new Link("https://github.com/Chantreck/tinkoff-java-bot");
        var expected = new GitHubResponse("Chantreck", "tinkoff-java-bot");

        var actual = parser.parseLink(link);

        assertEquals(expected, actual);
    }

    @Test
    void testCorrectGitHubLinkWithTrailingSlash() {
        var link = new Link("https://github.com/Chantreck/tinkoff-java-bot/");
        var expected = new GitHubResponse("Chantreck", "tinkoff-java-bot");

        var actual = parser.parseLink(link);

        assertEquals(expected, actual);
    }

    @Test
    void testCorrectGitHubLinkWithoutSchema() {
        var link = new Link("github.com/Chantreck/tinkoff-java-bot/");
        var expected = new GitHubResponse("Chantreck", "tinkoff-java-bot");

        var actual = parser.parseLink(link);

        assertEquals(expected, actual);
    }

    @Test
    void testGitHubUserProfileLink() {
        var link = new Link("https://github.com/Chantreck");
        var expected = new EmptyResponse();

        var actual = parser.parseLink(link);

        assertEquals(expected, actual);
    }

    @Test
    void testGitHubLink() {
        var link = new Link("https://github.com/");
        var expected = new EmptyResponse();

        var actual = parser.parseLink(link);

        assertEquals(expected, actual);
    }

    @Test
    void testOtherLink() {
        var link = new Link("https://edu.tinkoff.ru/");
        var expected = new EmptyResponse();

        var actual = parser.parseLink(link);

        assertEquals(expected, actual);
    }

    @Test
    void testMatchingLinkWithoutBaseUrl() {
        var link = new Link("https://edu.tinkoff.ru/Chantreck/tinkoff-java-bot/");
        var expected = new EmptyResponse();

        var actual = parser.parseLink(link);

        assertEquals(expected, actual);
    }

    @Test
    void testCorrectStackOverflowLink() {
        var link = new Link("https://stackoverflow.com/questions/60293663");
        var expected = new EmptyResponse();

        var actual = parser.parseLink(link);

        assertEquals(expected, actual);
    }
}
