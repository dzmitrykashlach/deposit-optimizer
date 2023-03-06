package com.dzmitrykashlach.components.entities

import com.fasterxml.jackson.annotation.JsonProperty

data class ExpressionValue(
    @JsonProperty("name") val name: String,
    @JsonProperty("value") val value: Int
)