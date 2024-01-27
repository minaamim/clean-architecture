package ddd.teople.cleanarchitecture.sample.application.service

import ddd.teople.cleanarchitecture.CleanArchitectureApplicationTests
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.ints.shouldBeGreaterThan
import io.kotest.matchers.shouldNotBe
import org.junit.jupiter.api.Assertions.*
import org.slf4j.LoggerFactory
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@SpringBootTest(classes = [CleanArchitectureApplicationTests::class])
@ActiveProfiles("test")
class FindNameServiceTest(
    private val findNameService: FindNameService
): BehaviorSpec({
    val log = LoggerFactory.getLogger(this::class.java)

    Given("이름을 찾고자 하는 샘플의 ID가 주어집니다.") {
        val id = 1L
        When("이름 찾기 서비스를 호출할 때") {
            val sample = findNameService.findName(id)
            Then("이름 찾기 결과 확인") {
                log.info("[findName] result: $sample")

                sample shouldNotBe null
                sample.length shouldBeGreaterThan 0
            }
        }
    }
})