package ddd.teople.cleanarchitecture.sample.application.port.`in`

interface FindNameUseCase {
    fun findName(sampleId: Long) : String
}