package com.tx.core.txmn

import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional

@Service
@Profile("txmn")
class SubService(
    val testTxRepository: TestTxRepository
) {
    // DataSourceTransactionManager
    @Transactional(transactionManager = "transactionManager", propagation = Propagation.REQUIRES_NEW)
    fun dataSourceSubTxFlush() {
        println("=========================")
        testTxRepository.saveAndFlush(TestTxEntity("ABC"))
        println("=========================")
    }

    // DataSourceTransactionManager
    @Transactional(transactionManager = "transactionManager", propagation = Propagation.REQUIRES_NEW)
    fun dataSourceSubTx() {
        println("=========================")
        testTxRepository.save(TestTxEntity("ABC"))
        println("=========================")
    }

    // JpaTransactionManager
    @Transactional(transactionManager = "jpaTransactionManager", propagation = Propagation.REQUIRES_NEW)
    fun jpaSubTxFlush() {
        println("=========================")
        testTxRepository.saveAndFlush(TestTxEntity("ABC"))
        println("=========================")
    }

    // JpaTransactionManager
    @Transactional(transactionManager = "jpaTransactionManager", propagation = Propagation.REQUIRES_NEW)
    fun jpaSubTx() {
        println("=========================")
        testTxRepository.save(TestTxEntity("ABC"))
        println("=========================")
    }
}