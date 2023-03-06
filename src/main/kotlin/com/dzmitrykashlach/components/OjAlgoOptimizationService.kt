package com.dzmitrykashlach.components

import com.dzmitrykashlach.components.entities.ExpressionDTO
import com.dzmitrykashlach.components.entities.ExpressionValue
import com.dzmitrykashlach.components.entities.ModelDTO
import com.dzmitrykashlach.components.entities.VariableDTO
import lombok.extern.slf4j.Slf4j
import org.ojalgo.optimisation.ExpressionsBasedModel
import org.ojalgo.optimisation.Optimisation
import org.ojalgo.optimisation.Variable
import org.springframework.stereotype.Service
import java.util.function.Consumer

/*
Example is taken from here:
https://medium.com/javarevisited/linear-programming-in-java-ab2289c72df9
https://github.com/pooran-c/linearProgrammingJava/blob/master/ojalgo/src/main/java/ojalgo/Farmer.java
*/
@Slf4j
@Service
class OjAlgoOptimizationService {
    fun calculate(modelDTO: ModelDTO): Optimisation.Result {
        val model = ExpressionsBasedModel()
        val variables: MutableMap<String?, Variable> = HashMap()
        modelDTO.variables.forEach(Consumer { v: VariableDTO ->
            val variable = Variable(v.name).weight(v.weight?.toLong()).lower(v.lower?.toLong())
            model.addVariable(variable)
            variables[v.name] = variable
        })
        modelDTO.expressions.forEach(Consumer { e: ExpressionDTO ->
            val expression = model.addExpression(e.name)
                .upper(e.upper.toLong())
                .lower(e.lower)
            e.values.forEach(Consumer { value: ExpressionValue ->
                expression[variables[value.name]] = value.value.toLong()
            })
        })
        return model.maximise()

    }
}