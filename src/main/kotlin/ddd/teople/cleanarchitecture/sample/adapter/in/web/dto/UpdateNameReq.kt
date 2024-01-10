package ddd.teople.cleanarchitecture.sample.adapter.`in`.web.dto

import ddd.teople.cleanarchitecture.sample.application.port.`in`.UpdateNameCommand

class UpdateNameReq (
    val sampleId: Long,
    val name: String
) {
    fun toCommand() = UpdateNameCommand(sampleId, name)
}