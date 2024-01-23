package ddd.teople.cleanarchitecture.sample.application.service

import ddd.teople.cleanarchitecture.CleanArchitectureApplicationTests
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.ints.shouldBeGreaterThan
import io.kotest.matchers.shouldNotBe
import org.slf4j.LoggerFactory
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@SpringBootTest(classes = [CleanArchitectureApplicationTests::class])
@ActiveProfiles("test")
class FindNameServiceTest(
    private val findNameService: FindNameService
): BehaviorSpec({
    // BehaviorSpec
    //  - official github: https://kotest.io/docs/framework/testing-styles.html
    //  - Kotest의 여러 style중 하나이며 BDD 스타일

    val log = LoggerFactory.getLogger(this::class.java)

    Given("먼저, 이름찾기 서비스를 위한 파라미터가 세팅되어 있다") {
        val sampleId = 1L

        When("만약, 이름찾기 서비스를 호출하면") {
            val result = findNameService.findName(sampleId = sampleId)

            Then("그러면, 이름찾기 서비스 결과 $result 확인한다") {
                log.info("[findName] result: $result")

                // 호출결과에 대한 Assertion
                result shouldNotBe null
                result.length shouldBeGreaterThan 0
            }
        }
    }
})