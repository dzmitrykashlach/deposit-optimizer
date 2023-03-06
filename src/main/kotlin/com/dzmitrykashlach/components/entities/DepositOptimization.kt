package com.dzmitrykashlach.components.entities

import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "depositOptimization")
data class DepositOptimization(val modelDTO: ModelDTO, val result: String)