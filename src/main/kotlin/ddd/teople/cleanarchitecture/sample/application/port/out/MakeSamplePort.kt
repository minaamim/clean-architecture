package ddd.teople.cleanarchitecture.sample.application.port.out

import ddd.teople.cleanarchitecture.sample.domain.Sample

interface MakeSamplePort {
    fun generate(sample: Sample) : Long?
}