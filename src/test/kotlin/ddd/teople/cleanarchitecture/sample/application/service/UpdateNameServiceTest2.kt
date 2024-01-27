package ddd.teople.cleanarchitecture.sample.application.service

import ddd.teople.cleanarchitecture.CleanArchitectureApplicationTests
import ddd.teople.cleanarchitecture.sample.application.port.`in`.UpdateNameCommand
import ddd.teople.cleanarchitecture.sample.domain.Sample
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.equals.shouldBeEqual
import org.junit.jupiter.api.Assertions.*
import org.slf4j.LoggerFactory
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import java.util.*

@SpringBootTest(classes = [CleanArchitectureApplicationTests::class])
@ActiveProfiles("test")
class UpdateNameServiceTest2(
    private val updateNameService: UpdateNameService
): BehaviorSpec({
    val log = LoggerFactory.getLogger(this::class.java)

    Given("수정하고자 하는 샘플의 id와 새로운 이름이 주어진다.") {
        val sample = Sample("before", 1L)
        val name = "after"

        When("업데이트 서비스 호출") {
            val result = updateNameService.updateName(UpdateNameCommand(sample.id!!, name))

            Then("sample의 이름이 변경되어야 한다") {
                log.info("[updateName] result: " + result.name)
                result.name shouldBeEqual name
            }
        }
    }
})