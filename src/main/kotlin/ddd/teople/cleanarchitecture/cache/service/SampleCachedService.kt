package ddd.teople.cleanarchitecture.cache.service

import ddd.teople.cleanarchitecture.sample.adapter.out.persistencce.SampleRepository
import ddd.teople.cleanarchitecture.sample.domain.Sample
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

@Service
class SampleCachedService internal constructor(
    private val sampleRepository: SampleRepository
) {
    @Cacheable("cacheElements")
    fun findSample(): List<Sample> {
        return sampleRepository.findAll();
    }

    @CacheEvict("cacheElements")
    fun removeElements() {
    }
}