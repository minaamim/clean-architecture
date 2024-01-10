package ddd.teople.cleanarchitecture.sample.adapter.`in`.web

import ddd.teople.cleanarchitecture.sample.application.port.`in`.MakeSampleUseCase
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MakeSampleController(private val makeSampleUseCase: MakeSampleUseCase) {
    @PostMapping("/api/v1/sample/making/{sampleName}")
    fun makeSample(@PathVariable sampleName: String) {
        makeSampleUseCase.generate(sampleName)
    }
}