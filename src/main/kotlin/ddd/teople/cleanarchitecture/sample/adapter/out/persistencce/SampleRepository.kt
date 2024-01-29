package ddd.teople.cleanarchitecture.sample.adapter.out.persistencce

import ddd.teople.cleanarchitecture.sample.domain.Sample
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface SampleRepository : JpaRepository<Sample, Long> {
    @Query("select s.name from sample s where s.id = (:sampleId)")
    fun findNameById(sampleId: Long) : String?
}