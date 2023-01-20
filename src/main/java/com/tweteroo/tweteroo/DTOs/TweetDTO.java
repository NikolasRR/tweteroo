package com.tweteroo.tweteroo.DTOs;

import jakarta.validation.constraints.NotBlank;

public record TweetDTO(
    @NotBlank String tweet,
    @NotBlank String username) {

}
