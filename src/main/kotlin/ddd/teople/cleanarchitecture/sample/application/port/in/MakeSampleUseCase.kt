package ddd.teople.cleanarchitecture.sample.application.port.`in`

import ddd.teople.cleanarchitecture.sample.domain.Sample

interface MakeSampleUseCase {
    fun generate(sampleName: String) : Sample
}