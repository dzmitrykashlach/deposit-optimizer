package com.dzmitrykashlach.components.controllers

import com.dzmitrykashlach.components.DepositOptimizationRepository
import com.dzmitrykashlach.components.OjAlgoOptimizationService
import com.dzmitrykashlach.components.entities.DepositOptimization
import com.dzmitrykashlach.components.entities.ModelDTO
import org.ojalgo.optimisation.Optimisation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
class DepositOptimizationController {

    @Autowired
    val service: OjAlgoOptimizationService? = null
    @Autowired
    val repository: DepositOptimizationRepository? = null

    @PostMapping(
        "/depositOptimization",
        "application/json", "application/json"
    )
    fun postOptimization(@RequestBody modelDTO: ModelDTO) {
        val result: Optimisation.Result? = service?.calculate(modelDTO)
        val depositOptimization = DepositOptimization(modelDTO, result.toString())
        repository?.save(depositOptimization)
            ?.subscribe()
    }

    @GetMapping("/depositOptimization")
    fun getOptimization(): Flux<DepositOptimization?>? {
        return repository?.findAll()
    }
}