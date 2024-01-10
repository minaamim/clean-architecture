package ddd.teople.cleanarchitecture.sample.adapter.`in`.web

import ddd.teople.cleanarchitecture.sample.adapter.`in`.web.dto.UpdateNameReq
import ddd.teople.cleanarchitecture.sample.application.port.`in`.UpdateNameUseCase
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UpdateNameController(private val updateNameUseCase: UpdateNameUseCase) {
    @PatchMapping("/api/v1/sample/update-name")
    fun updateName(@RequestBody request: UpdateNameReq) {
        updateNameUseCase.updateName(request.toCommand())
    }
}