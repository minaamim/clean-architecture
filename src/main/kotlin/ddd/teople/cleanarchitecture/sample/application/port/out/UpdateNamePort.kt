package ddd.teople.cleanarchitecture.sample.application.port.out

import ddd.teople.cleanarchitecture.sample.domain.Sample

interface UpdateNamePort {
    fun save(sample: Sample)
}