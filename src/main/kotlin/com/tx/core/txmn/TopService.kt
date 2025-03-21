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
    fun dataSourceFindAfterTopTxFlush() {
        println("dataSourceFindAfterTopTxFlush")
        println("=========================")
        val findAll = testTxRepository.findAll()
        subService.dataSourceSubTxFlush()
        println("=========================")

        /**
         * swagger
         * dataSourceFindAfterTopTxFlush
         * =========================
         * Hibernate: select tte1_0.id,tte1_0.name from test_tx tte1_0
         * =========================
         * Hibernate: select next value for test_tx_seq
         * 2025-03-21T16:51:22.813+09:00 ERROR 34596 --- [nio-8080-exec-6] o.a.c.c.C.[.[.[/].[dispatcherServlet]    : Servlet.service() for servlet [dispatcherServlet] in context with path [] threw exception [Request processing failed: org.springframework.dao.InvalidDataAccessApiUsageException: no transaction is in progress] with root cause
         *
         * jakarta.persistence.TransactionRequiredException: no transaction is in progress
         */

        /**
         * 테스트코드
         * dataSourceFindAfterTopTxFlush
         * =========================
         * Hibernate: select tte1_0.id,tte1_0.name from test_tx tte1_0
         * =========================
         * Hibernate: select next value for test_tx_seq
         */
    }
    
    // DataSourceTransactionManager
    @Transactional(transactionManager = "transactionManager")
    fun dataSourceTopTxFlush() {
        println("dataSourceTopTxFlush")
        println("=========================")
        subService.dataSourceSubTxFlush()
        println("=========================")

        /**
         * swagger
         * dataSourceTopTxFlush
         * =========================
         * =========================
         * Hibernate: select next value for test_tx_seq
         * Hibernate: insert into test_tx (name,id) values (?,?)
         * =========================
         * =========================
         */

        /**
         * 테스트코드
         * dataSourceTopTxFlush
         * =========================
         * =========================
         * Hibernate: select next value for test_tx_seq
         *
         * -->>>> SubService.subTx() -> saveAndFlush() 부분에서 발생!
         * 왜???
         */
    }

    // DataSourceTransactionManager
    @Transactional(transactionManager = "transactionManager")
    fun dataSourceTopTx() {
        println("dataSourceTopTx")
        println("=========================")
        subService.dataSourceSubTx()
        println("=========================")
        /**
         * swagger
         * dataSourceTopTx
         * =========================
         * =========================
         * Hibernate: select next value for test_tx_seq
         * =========================
         * Hibernate: insert into test_tx (name,id) values (?,?)
         * =========================
         */
        /**
         * 테스트코드
         * dataSourceTopTx
         * =========================
         * =========================
         * =========================
         * =========================
         *
         * ????? 이건 왜??
         */
    }


    // JpaTransactionManager
    @Transactional(transactionManager = "jpaTransactionManager")
    fun jpaTopTxFlush() {
        println("jpaTopTxFlush")
        println("=========================")
        subService.jpaSubTxFlush()
        println("=========================")
        /**
         * swagger
         * jpaTopTxFlush
         * =========================
         * =========================
         * Hibernate: insert into test_tx (name,id) values (?,?)
         * =========================
         * =========================
         */
        /**
         * 테스트코드
         * jpaTopTxFlush
         * =========================
         * =========================
         * Hibernate: select next value for test_tx_seq
         * Hibernate: insert into test_tx (name,id) values (?,?)
         * =========================
         * =========================
         */
    }

    // JpaTransactionManager
    @Transactional(transactionManager = "jpaTransactionManager")
    fun jpaTopTx() {
        println("jpaTopTx")
        println("=========================")
        subService.jpaSubTx()
        println("=========================")
        /**
         * swagger
         * jpaTopTx
         * =========================
         * =========================
         * =========================
         * Hibernate: insert into test_tx (name,id) values (?,?)
         * =========================
         */
        /**
         * 테스트코드
         * jpaTopTx
         * =========================
         * =========================
         * =========================
         * Hibernate: insert into test_tx (name,id) values (?,?)
         * =========================
         *
         *
         */
    }


    // DataSourceTransactionManager
    @Transactional(transactionManager = "transactionManager")
    fun dataSourceTxFlush() {
        println("dataSourceTxFlush")
        println("=========================")
        testTxRepository.saveAndFlush(TestTxEntity("ABC"))
        println("=========================")
        /**
         * swagger
         * dataSourceTopTx
         * =========================
         * =========================
         * =========================
         * Hibernate: insert into test_tx (name,id) values (?,?)
         * =========================
         */
        /**
         * dataSourceTopTx
         * =========================
         * =========================
         * =========================
         * =========================
         *
         */
    }

}