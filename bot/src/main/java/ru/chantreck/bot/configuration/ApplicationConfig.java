package ru.chantreck.bot.configuration;

import jakarta.validation.constraints.NotNull;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;
import ru.chantreck.bot.configuration.model.ExternalUrl;
import ru.chantreck.bot.configuration.model.TelegramProperties;

@Validated
@ConfigurationProperties(prefix = "app", ignoreUnknownFields = false)
public record ApplicationConfig(
        @NotNull String test,
        @NotNull TelegramProperties telegram,
        @NotNull ExternalUrl externalUrl
) {}
