package com.tx.core.norollback

import com.tx.core.CommonTestEntity
import com.tx.core.CommonTestRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class NoRollbackService(
    val commonTestRepository: CommonTestRepository
) {

    @Transactional(noRollbackFor = [NoRollbackException::class])
    fun noRollback() {
        println("==================")
        commonTestRepository.save(CommonTestEntity("ABC"))
        println("==================")
        val runtimeException = RuntimeException("Ex")
        val exception = NoRollbackException(runtimeException)
        throw exception
    }
}