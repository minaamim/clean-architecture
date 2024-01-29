package feature.step.sample.edge

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import ddd.teople.cleanarchitecture.sample.domain.Sample
import io.cucumber.java.ko.그러면
import io.cucumber.java.ko.만약
import io.cucumber.java.ko.먼저
import io.kotest.matchers.longs.shouldBeGreaterThan
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.ResultActionsDsl
import org.springframework.test.web.servlet.post

class MakeSampleEdgeStep {

    @Autowired
    private lateinit var mockMvc: MockMvc

    private lateinit var resultActions: ResultActionsDsl
    private lateinit var sampleName: String

    @먼저("생성 실패 api 호출을 위한 {string} 있다")
    fun 생성_실패_api_호출을_위한_있다(name: String) {
        sampleName = name
    }

    @만약("생성 실패 api를 호출하면")
    fun 생성_실패_api를_호출하면() {
        resultActions = mockMvc.post("/api/v1/sample/making/{sampleName}", sampleName) {
            contentType = MediaType.APPLICATION_JSON
        }
    }

    @그러면("생성 실패 api 호출 결과 {int} 확인한다")
    fun 생성_실패_api_호출_결과_확인한다(status: Int) {
        val mvcResult = resultActions.andDo {
            print()
        }.andReturn()

        mvcResult.response.status shouldBe status
    }
}