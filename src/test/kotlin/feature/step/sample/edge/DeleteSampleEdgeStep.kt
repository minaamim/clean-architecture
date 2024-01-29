package feature.step.sample.edge

import io.cucumber.java.ko.그러면
import io.cucumber.java.ko.만약
import io.cucumber.java.ko.먼저
import io.kotest.matchers.shouldBe
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.ResultActionsDsl
import org.springframework.test.web.servlet.delete

class DeleteSampleEdgeStep {
    @Autowired
    private lateinit var mockMvc: MockMvc

    private lateinit var resultActions: ResultActionsDsl
    private lateinit var sampleId: String

    @먼저("삭제 실패 api 호출을 위한 {string} 있다")
    fun 삭제_실패_api_호출을_위한_있다(id: String) {
        sampleId = id
    }

    @만약("삭제 실패 api를 호출하면")
    fun 삭제_실패_api를_호출하면() {
        resultActions = mockMvc.delete("/api/v1/sample/delete-sample/{sampleId}", sampleId)
    }

    @그러면("삭제 실패 api 호출 결과 {int} 확인한다")
    fun 삭제_실패_api_호출_결과_확인한다(status: Int) {
        val mvcResult = resultActions.andDo {
            print()
        }.andReturn()

        mvcResult.response.status shouldBe status
    }
}