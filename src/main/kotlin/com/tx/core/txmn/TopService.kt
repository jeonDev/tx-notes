package com.tx.core.txmn

import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Profile("txmn")
class TopService(
    val testTxRepository: TestTxRepository,
    val subService: SubService
) {

    // DataSourceTransactionManager
    @Transactional(transactionManager = "transactionManager")
    fun dataSourceTopTxFlush() {
        println("=========================")
        subService.dataSourceSubTxFlush()
        println("=========================")

        /**
         * =========================
         * =========================
         * Hibernate: select next value for test_tx_seq
         *
         * org.springframework.dao.InvalidDataAccessApiUsageException: no transaction is in progress
         *
         * -->>>> SubService.subTx() -> saveAndFlush() 부분에서 발생!
         * 왜???
         */
    }

    // DataSourceTransactionManager
    @Transactional(transactionManager = "transactionManager")
    fun dataSourceTopTx() {
        println("=========================")
        subService.dataSourceSubTx()
        println("=========================")
        /**
         * =========================
         * =========================
         * =========================
         * =========================
         * ????? 이건 왜??
         */
    }


    // JpaTransactionManager
    @Transactional(transactionManager = "jpaTransactionManager")
    fun jpaTopTxFlush() {
        println("=========================")
        subService.jpaSubTxFlush()
        println("=========================")
        /**
         * =========================
         * =========================
         * Hibernate: select next value for test_tx_seq
         * Hibernate: insert into test_tx (name,id) values (?,?)
         * =========================
         * =========================
         *
         */
    }

    // JpaTransactionManager
    @Transactional(transactionManager = "jpaTransactionManager")
    fun jpaTopTx() {
        println("=========================")
        subService.jpaSubTx()
        println("=========================")
        /**
         * =========================
         * =========================
         * =========================
         * Hibernate: insert into test_tx (name,id) values (?,?)
         * =========================
         *
         */
    }


}