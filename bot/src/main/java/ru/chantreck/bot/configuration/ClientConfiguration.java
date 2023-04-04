package ru.chantreck.bot.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.chantreck.bot.webclient.scrapper.ScrapperClient;
import ru.chantreck.bot.webclient.scrapper.ScrapperClientImpl;

@Configuration
public class ClientConfiguration {
    @Bean
    public String scrapperDefaultUrl(ApplicationConfig config) {
        return config.externalUrl().scrapperUrl();
    }

    @Bean
    public ScrapperClient scrapperClient(String defaultUrl) {
        return new ScrapperClientImpl(defaultUrl);
    }
}
