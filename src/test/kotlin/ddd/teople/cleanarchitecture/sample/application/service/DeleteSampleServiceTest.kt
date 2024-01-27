package ddd.teople.cleanarchitecture.sample.application.service

import ddd.teople.cleanarchitecture.CleanArchitectureApplicationTests
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.ints.exactly
import org.junit.jupiter.api.Assertions.*
import org.junit.platform.commons.logging.LoggerFactory
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@SpringBootTest(classes = [CleanArchitectureApplicationTests::class])
@ActiveProfiles("test")
class DeleteSampleServiceTest(
    private val deleteSampleService: DeleteSampleService
    ): BehaviorSpec({
    val log = LoggerFactory.getLogger(this::class.java)

    Given("삭제할 샘플의 id가 주어진다") {

        val id = 1L

        When("서비스 호출") {
            deleteSampleService.deleteSample(id)
            Then("삭제되어야 함") {

            }
        }
    }

})