package com.tx.core.txjpasave

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.Commit
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
@Transactional(value = "jpaTransactionManager")
class TxJpaSaveServiceTest(
    @Autowired
    var txJpaSaveService: TxJpaSaveService
) {
    /**
     * 테스트코드에선 둘 다 insert 쿼리 실행.
     */
    @Test
    @Commit
    fun 트랜잭션없는_insert쿼리_실행() {
        txJpaSaveService.noTransactionSave()
    }

    @Test
    @Commit
    fun 트랜잭션있는_insert쿼리_실행() {
        txJpaSaveService.transactionSave()
    }
}
