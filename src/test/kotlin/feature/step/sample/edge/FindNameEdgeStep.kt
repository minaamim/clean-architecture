package feature.step.sample.edge

import io.cucumber.java.ko.그러면
import io.cucumber.java.ko.만약
import io.cucumber.java.ko.먼저
import io.kotest.matchers.ints.shouldBeGreaterThan
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.ResultActionsDsl
import org.springframework.test.web.servlet.get

class FindNameEdgeStep {
    private val log = LoggerFactory.getLogger(this::class.java)

    @Autowired
    private lateinit var mockMvc: MockMvc

    private lateinit var resultActions: ResultActionsDsl
    private lateinit var paramSampleId: String

    @먼저("조회 실패 api 호출을 위한 {string} 있다")
    fun 조회_실패_api_호출을_위한_있다(sampleId: String) {
        paramSampleId = sampleId
    }

    @만약("조회 실패 api를 호출하면")
    fun 조회_실패_api를_호출하면() {
        resultActions = mockMvc.get("/api/v1/sample/{sampleId}/name", paramSampleId) {
            contentType = MediaType.APPLICATION_JSON
        }
    }

    @그러면("조회 실패 api 호출 결과 {int} 확인한다")
    fun 조회_실패_api_호출_결과_확인한다(status: Int) {
        val mvcResult = resultActions.andDo {
            print()
        }.andReturn()

        mvcResult.response.status shouldBe status

        val responseBody = mvcResult.response.contentAsString;

        log.info("[조회_api_호출결과_확인] responseBody: $responseBody")

        responseBody shouldNotBe null
        responseBody.length shouldBeGreaterThan 0
    }
}