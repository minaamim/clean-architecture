package ddd.teople.cleanarchitecture.sample.application.service

import ddd.teople.cleanarchitecture.sample.application.port.`in`.MakeSampleUseCase
import ddd.teople.cleanarchitecture.sample.application.port.out.MakeSamplePort
import ddd.teople.cleanarchitecture.sample.domain.Sample
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
@Transactional
class MakeSampleService(private val port: MakeSamplePort) : MakeSampleUseCase {
    override fun generate(sampleName: String) : Sample {
        val sample = Sample(sampleName)
        port.generate(sample)?: throw IllegalStateException("New sample creation failed")
        return sample
    }
}