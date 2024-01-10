package ddd.teople.cleanarchitecture.sample.application.service

import ddd.teople.cleanarchitecture.sample.application.port.`in`.DeleteSampleUseCase
import ddd.teople.cleanarchitecture.sample.application.port.out.DeleteSamplePort

class DeleteSampleService(private val deleteSamplePort: DeleteSamplePort) : DeleteSampleUseCase {
    override fun deleteSample(sampleId: Long) {
        deleteSamplePort.delete(sampleId)
    }
}