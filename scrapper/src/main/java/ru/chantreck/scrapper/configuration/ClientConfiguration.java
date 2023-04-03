package ru.chantreck.scrapper.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.chantreck.scrapper.webclient.github.GitHubClient;
import ru.chantreck.scrapper.webclient.github.GitHubClientImpl;
import ru.chantreck.scrapper.webclient.stackoverflow.StackOverflowClient;
import ru.chantreck.scrapper.webclient.stackoverflow.StackOverflowClientImpl;

@Configuration
public class ClientConfiguration {
    @Bean
    GitHubClient gitHubClient() {
        return new GitHubClientImpl();
    }

    @Bean
    StackOverflowClient stackOverflowClient() {
        return new StackOverflowClientImpl();
    }
}
