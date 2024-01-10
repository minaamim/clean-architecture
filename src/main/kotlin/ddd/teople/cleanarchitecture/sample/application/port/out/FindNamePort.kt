package ddd.teople.cleanarchitecture.sample.application.port.out

interface FindNamePort {
    fun findName(sampleId: Long) : String?
}