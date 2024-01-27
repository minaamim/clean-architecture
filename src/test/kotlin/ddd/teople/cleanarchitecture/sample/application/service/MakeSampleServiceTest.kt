package ddd.teople.cleanarchitecture.sample.application.service

import ddd.teople.cleanarchitecture.CleanArchitectureApplicationTests
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.longs.shouldBeGreaterThan
import io.kotest.matchers.shouldNotBe
import org.junit.jupiter.api.Assertions.*
import org.slf4j.LoggerFactory
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@SpringBootTest(classes = [CleanArchitectureApplicationTests::class])
@ActiveProfiles("test")
class MakeSampleServiceTest(
    private val makeSampleService: MakeSampleService
    ): BehaviorSpec({

    val log = LoggerFactory.getLogger(this::class.java)

    Given("to make sample, there's a name for it") {
        val name = "sample"
        When("when call service") {
            val sample = makeSampleService.generate(name)
            Then("check the result") {
                log.info("[makeSample] sample id: ${sample.id}, name: ${sample.name}")

                sample shouldNotBe null
                sample.id!! shouldBeGreaterThan 0
            }
        }
    }

})