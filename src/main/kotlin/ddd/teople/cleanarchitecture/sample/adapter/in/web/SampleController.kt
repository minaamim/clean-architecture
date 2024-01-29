package ddd.teople.cleanarchitecture.sample.adapter.`in`.web

import ddd.teople.cleanarchitecture.sample.adapter.`in`.web.dto.UpdateNameReq
import ddd.teople.cleanarchitecture.sample.application.port.`in`.DeleteSampleUseCase
import ddd.teople.cleanarchitecture.sample.application.port.`in`.FindNameUseCase
import ddd.teople.cleanarchitecture.sample.application.port.`in`.MakeSampleUseCase
import ddd.teople.cleanarchitecture.sample.application.port.`in`.UpdateNameUseCase
import ddd.teople.cleanarchitecture.sample.domain.Sample
import jakarta.validation.constraints.NotBlank
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
class SampleController(
    private val findNameUseCase: FindNameUseCase,
    private val makeSampleUseCase: MakeSampleUseCase,
    private val updateNameUseCase: UpdateNameUseCase,
    private val deleteSampleUseCase: DeleteSampleUseCase
) {
    @GetMapping("/api/v1/sample/{sampleId}/name")
    fun findName(@PathVariable sampleId: Long) : String {
        return findNameUseCase.findName(sampleId)
    }

    @PostMapping("/api/v1/sample/making/{sampleName}")
    fun makeSample(@PathVariable("sampleName") @NotBlank sampleName: String) : Sample{
        return makeSampleUseCase.generate(sampleName)
    }

    @PatchMapping("/api/v1/sample/update-name")
    fun updateName(@RequestBody @Validated request: UpdateNameReq) : Sample {
        return updateNameUseCase.updateName(request.toCommand())
    }

    @DeleteMapping("/api/v1/sample/delete-sample/{sampleId}")
    fun deleteSample(@PathVariable sampleId: Long) {
        deleteSampleUseCase.deleteSample(sampleId)
    }
}