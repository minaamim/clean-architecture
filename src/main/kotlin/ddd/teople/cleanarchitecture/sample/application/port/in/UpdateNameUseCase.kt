package ddd.teople.cleanarchitecture.sample.application.port.`in`

import ddd.teople.cleanarchitecture.sample.domain.Sample

interface UpdateNameUseCase {
    fun updateName(updateNameCommand: UpdateNameCommand) : Sample
}