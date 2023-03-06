package com.dzmitrykashlach.components

import com.dzmitrykashlach.components.entities.DepositOptimization
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface DepositOptimizationRepository : ReactiveMongoRepository<DepositOptimization?, Long?>