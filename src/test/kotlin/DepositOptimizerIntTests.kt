import com.dzmitrykashlach.components.OjAlgoOptimizationService
import com.dzmitrykashlach.components.entities.ModelDTO
import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class DepositOptimizerIntTests {
    private val service = OjAlgoOptimizationService()
    @Test
    @Throws(JsonProcessingException::class)
    fun ojAlgoServiceTest() {
        val json =
            "{\"variables\":[{\"name\":\"Amount of gold\",\"description\":\"\",\"weight\":300,\"lower\":0,\"upper\":2000}," +
                    "{\"name\":\"Amount of silver\",\"weight\":150,\"lower\":0,\"upper\":2000}]," +
                    "\"expressions\":[{\"name\":\"Cost\",\"description\":\"2000 * goldAmount + 1000 * silverAmount <= 50000\",\"lower\":0,\"upper\":50000," +
                    "\"values\":[{\"name\":\"Amount of gold\",\"value\":2000}," +
                    "{\"name\":\"Amount of silver\",\"value\":1000}]},{\"name\":\"Investment duration\",\"description\":\"300 * goldAmount + 150 * silverAmount <= 730(2 years)\",\"lower\":0,\"upper\":730," +
                    "\"values\":[{\"name\":\"Amount of gold\",\"value\":90}," +
                    "{\"name\":\"Amount of silver\",\"value\":35}]},{\"name\":\"Total weight\",\"description\":\"goldAmount + silverAmount <= 50\",\"lower\":0,\"upper\":50," +
                    "\"values\":[{\"name\":\"Amount of gold\",\"value\":1},{\"name\":\"Amount of silver\",\"value\":1}]}]," +
                    "\"description\":\"Max profit = 300 * goldAmount + 100 * silverAmount\"}"
        val mapper = ObjectMapper()
        val modelDTO = mapper.readValue(json, ModelDTO::class.java)
        Assertions.assertEquals(
            "OPTIMAL 3128.5714285714284 @ { 0, 20.85714285714285714285714285714286 }",
            service.calculate(modelDTO).toString()
        )
    }
}