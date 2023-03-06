package com.dzmitrykashlach

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DepositOptimizerApplication {
    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            runApplication<DepositOptimizerApplication>(*args)
        }

    }
}