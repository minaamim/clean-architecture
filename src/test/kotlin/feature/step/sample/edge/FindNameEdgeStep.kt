package feature.step.sample.edge

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
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
import org.springframework.util.LinkedMultiValueMap

class FindNameEdgeStep {
    private val log = LoggerFactory.getLogger(this::class.java)

    @Autowired
    private lateinit var mockMvc: MockMvc
    @Autowired
    private lateinit var om: ObjectMapper

    private lateinit var resultActions: ResultActionsDsl
    private lateinit var paramMap: LinkedMultiValueMap<String, String>

    @먼저("실패 조회 api호출을 위한 {string} 있다")
    fun 실패_조회_api호출을_위한_있다(sampleId: String) {
        paramMap = LinkedMultiValueMap<String, String>()
        paramMap.add("sampleId", sampleId)
    }

    @만약("실패 조회 api를 호출하면")
    fun 실패_조회_api를_호출하면() {
        mockMvc.get("/api/v1/sample/{sampleId}/name") {
            contentType = MediaType.APPLICATION_JSON
            params = paramMap
        }
    }

    @그러면("실패 조회 api 호출결과 {int} 확인한다")
    fun 실패_조회_api_호출결과_확인한다(status: Int) {
        val mvcResult = resultActions.andDo { print() }.andReturn()

        mvcResult.response.status shouldBe status

        // 필요에 따라 응답값을 매핑하여 테스트 가능
        val responseBody = om.readValue(mvcResult.response.contentAsString, object : TypeReference<String>() {})
        log.info("[조회_api_호출결과_확인한다] responseBody: $responseBody")

        responseBody shouldNotBe null
        responseBody.length shouldBeGreaterThan 0
    }
}