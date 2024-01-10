package ddd.teople.cleanarchitecture.sample.adapter.`in`.web

import ddd.teople.cleanarchitecture.sample.application.port.`in`.FindNameUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class FindNameController(private val findNameUseCase: FindNameUseCase) {
    @GetMapping("/api/v1/sample/{sampleId}/name")
    fun findName(@PathVariable sampleId: Long) : String {
        return findNameUseCase.findName(sampleId)
    }
}