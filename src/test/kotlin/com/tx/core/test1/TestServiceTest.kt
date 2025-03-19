package com.tx.core.test1

import jakarta.persistence.TransactionRequiredException
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.Rollback
import org.springframework.test.context.ActiveProfiles

@SpringBootTest
@ActiveProfiles("test1")
class TestServiceTest(
    @Autowired
    var testService: TestService
) {

    @Test
    @Rollback(false)
    fun save_시퀀스_쿼리실행시점() {
        testService.transactionSavePersist()
    }

    @Test
    @Rollback(false)
    fun save_쿼리실행시점() {
        testService.transactionNoSequenceSavePersist()
    }

    @Test
    @Rollback(false)
    fun em_시퀀스_쿼리실행시점() {
        testService.transactionPersist()
    }

    @Test
    @Rollback(false)
    fun em_시퀀스_flush_쿼리실행시점() {
        testService.transactionPersistFlush()
    }

    @Test
    @Rollback(false)
    fun em_쿼리실행시점() {
        testService.transactionNoSeqPersist()
    }

    @Test
    @Rollback(false)
    fun em_flush_쿼리실행시점() {
        testService.transactionNoSeqPersistFlush()
    }

    @Test
    @Rollback(false)
    fun em_트랜잭션없음() {
        assertThrows(TransactionRequiredException::class.java) {
            testService.noTransactionPersist()
        }
    }
}