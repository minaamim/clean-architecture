package ddd.teople.cleanarchitecture.cache.service

import com.ninjasquad.springmockk.MockkBean
import ddd.teople.cleanarchitecture.CleanArchitectureApplicationTests
import ddd.teople.cleanarchitecture.sample.adapter.out.persistencce.SampleRepository
import ddd.teople.cleanarchitecture.sample.domain.Sample
import io.mockk.every
import io.mockk.junit5.MockKExtension
import io.mockk.verify
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(classes = [CleanArchitectureApplicationTests::class])
@ExtendWith(MockKExtension::class)
class SampleCachedServiceMockTest @Autowired constructor(
    private val cachedService: SampleCachedService
) {

    @MockkBean
    private lateinit var sampleRepository: SampleRepository

    @BeforeEach
    fun setUp() {
        every { sampleRepository.findAll() } returns listOf(Sample("name1"), Sample("name2"), Sample("name3"))
    }

    @Test
    fun findSamplesTest() {
        cachedService.findSample()
        cachedService.findSample()

        verify (exactly = 1){ sampleRepository.findAll() }
    }

    @AfterEach
    fun removeElements() {
        cachedService.removeElements()
    }
}