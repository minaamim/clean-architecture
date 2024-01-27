package ddd.teople.cleanarchitecture.sample.adapter.out.persistencce

import ddd.teople.cleanarchitecture.sample.application.port.out.*
import ddd.teople.cleanarchitecture.sample.domain.Sample
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository

@Repository
class SamplePersistenceAdapter(
    private val sampleRepository: SampleRepository
    ) : LoadSamplePort, UpdateNamePort, FindNamePort, MakeSamplePort, DeleteSamplePort {

    override fun loadSample(sampleId: Long): Sample? {
        return sampleRepository.findByIdOrNull(sampleId)
    }

    override fun save(sample: Sample) {
        sampleRepository.save(sample)
    }

    override fun findName(sampleId: Long): String? {
        return sampleRepository.findNameById(sampleId)
    }

    override fun generate(sample: Sample) : Long? {
        return sampleRepository.save(sample).id
    }

    override fun delete(sampleId: Long) {
        sampleRepository.deleteById(sampleId)
    }
}