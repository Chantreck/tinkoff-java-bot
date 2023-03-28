package ru.chantreck.scrapper.webclient.github.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;

public record GitHubRepositoryResponse(
        @JsonProperty("updated_at") OffsetDateTime updatedAt
) {
}
