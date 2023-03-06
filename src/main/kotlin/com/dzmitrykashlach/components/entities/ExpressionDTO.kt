package com.dzmitrykashlach.components.entities

import com.fasterxml.jackson.annotation.JsonProperty

data class ExpressionDTO(
    @JsonProperty("name") val name: String,
    @JsonProperty("description") val description: String,
    @JsonProperty("lower") val lower: Int,
    @JsonProperty("upper") val upper: Int,
    @JsonProperty("values") val values: List<ExpressionValue>
)