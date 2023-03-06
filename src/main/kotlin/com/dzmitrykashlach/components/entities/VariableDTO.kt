package com.dzmitrykashlach.components.entities

import com.fasterxml.jackson.annotation.JsonProperty

data class VariableDTO(
    @JsonProperty("name") val name: String?,
    @JsonProperty("description") val description: String?,
    @JsonProperty("weight") val weight: Int?,
    @JsonProperty("lower") val lower: Int?,
    @JsonProperty("upper") val upper: Int?)