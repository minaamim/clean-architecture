package ddd.teople.cleanarchitecture.sample.application.service

import ddd.teople.cleanarchitecture.common.exception.BusinessException
import ddd.teople.cleanarchitecture.common.exception.ErrorCode
import ddd.teople.cleanarchitecture.sample.application.port.`in`.FindNameUseCase
import ddd.teople.cleanarchitecture.sample.application.port.out.FindNamePort
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
@Transactional
class FindNameService(private val findNamePort: FindNamePort) : FindNameUseCase {
    override fun findName(sampleId: Long) : String {
        return findNamePort.findName(sampleId)?: throw BusinessException(ErrorCode.MEMBER_NOT_FOUND)
    }
}