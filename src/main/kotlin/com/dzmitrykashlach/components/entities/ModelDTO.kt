package com.dzmitrykashlach.components.entities

import com.fasterxml.jackson.annotation.JsonProperty

data class ModelDTO(
    @JsonProperty("variables") val variables: List<VariableDTO>,
    @JsonProperty("expressions") val expressions: List<ExpressionDTO>,
    @JsonProperty("description") val description: String
)