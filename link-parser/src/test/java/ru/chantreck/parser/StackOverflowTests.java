package ru.chantreck.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import ru.chantreck.parser.impl.StackOverflowParser;
import ru.chantreck.parser.response.EmptyResponse;
import ru.chantreck.parser.response.StackOverflowResponse;

public class StackOverflowTests {
    private final StackOverflowParser parser = new StackOverflowParser(null);

    @Test
    void testCorrectStackOverflowLink() {
        var link = new Link("https://stackoverflow.com/questions/60293663");
        var expected = new StackOverflowResponse(60293663);

        var actual = parser.parseLink(link);

        assertEquals(expected, actual);
    }

    @Test
    void testCorrectStackOverflowLinkWithQuestionTitle() {
        var link = new Link("https://stackoverflow.com/questions/60293663/distinguish-null-from-missing-properties-in-jackson-using-kotlin-data-classes");
        var expected = new StackOverflowResponse(60293663);

        var actual = parser.parseLink(link);

        assertEquals(expected, actual);
    }

    @Test
    void testCorrectStackOverflowLinkWithTrailingSlash() {
        var link = new Link("https://stackoverflow.com/questions/60293663/");
        var expected = new StackOverflowResponse(60293663);

        var actual = parser.parseLink(link);

        assertEquals(expected, actual);
    }

    @Test
    void testCorrectStackOverflowLinkWithoutSchema() {
        var link = new Link("stackoverflow.com/questions/60293663/");
        var expected = new StackOverflowResponse(60293663);

        var actual = parser.parseLink(link);

        assertEquals(expected, actual);
    }

    @Test
    void testStackoverflowShareLink() {
        var link = new Link("https://stackoverflow.com/q/60293663");
        var expected = new EmptyResponse();

        var actual = parser.parseLink(link);

        assertEquals(expected, actual);
    }

    @Test
    void testLinkWithoutNumber() {
        var link = new Link("https://stackoverflow.com/q/");
        var expected = new EmptyResponse();

        var actual = parser.parseLink(link);

        assertEquals(expected, actual);
    }

    @Test
    void testStackOverflowLink() {
        var link = new Link("https://stackoverflow.com/");
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
        var link = new Link("https://edu.tinkoff.ru/questions/60293663/");
        var expected = new EmptyResponse();

        var actual = parser.parseLink(link);

        assertEquals(expected, actual);
    }

    @Test
    void testCorrectGitHubLink() {
        var link = new Link("https://github.com/Chantreck/tinkoff-java-bot");
        var expected = new EmptyResponse();

        var actual = parser.parseLink(link);

        assertEquals(expected, actual);
    }
}
