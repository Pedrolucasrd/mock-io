package com.mock.UcMocker.model.dto;


import io.swagger.v3.oas.annotations.media.Schema;

public record ContentRequest(
        @Schema(description = "{\\\"key\\\":\\\"value\\\"}")
        String key
) {
}
