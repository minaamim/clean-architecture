package ddd.teople.cleanarchitecture.sample.adapter.`in`.web.dto

import ddd.teople.cleanarchitecture.sample.application.port.`in`.UpdateNameCommand
import jakarta.validation.constraints.NotBlank

class UpdateNameReq (
    val sampleId: Long,
    @field: NotBlank
    @get:NotBlank
    val name: String
) {
    fun toCommand() = UpdateNameCommand(sampleId, name)
}