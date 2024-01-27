package ddd.teople.cleanarchitecture.sample.application.service

import ddd.teople.cleanarchitecture.sample.application.port.`in`.UpdateNameCommand
import ddd.teople.cleanarchitecture.sample.application.port.`in`.UpdateNameUseCase
import ddd.teople.cleanarchitecture.sample.application.port.out.LoadSamplePort
import ddd.teople.cleanarchitecture.sample.application.port.out.UpdateNamePort
import ddd.teople.cleanarchitecture.sample.domain.Sample
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service


@Service
class UpdateNameService(
    private val loadSamplePort: LoadSamplePort,
    private val updateNamePort: UpdateNamePort
    ): UpdateNameUseCase {
    override fun updateName(command: UpdateNameCommand) : Sample {
        val sample = loadSamplePort.loadSample(command.SampleId) ?: throw IllegalStateException("this sample does not exist")

        sample.updateName(command.name)
        updateNamePort.save(sample)
        return sample;
    }
}