package com.tx.core.txmn

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.dao.InvalidDataAccessApiUsageException
import org.springframework.test.annotation.Rollback
import org.springframework.test.context.ActiveProfiles

@SpringBootTest
@ActiveProfiles("txmn")
class TopServiceTest(
    @Autowired
    var topService: TopService
) {

    @Test
    @Rollback(false)
    fun DataSourceTm_하위트랜잭션_조회후_REQUIREWS_NEW_saveAndFlush() {
        assertThrows(InvalidDataAccessApiUsageException::class.java) {
            topService.dataSourceFindAfterTopTxFlush()
        }
    }

    @Test
    @Rollback(false)
    fun DataSourceTm_하위트랜잭션_REQUIREWS_NEW_saveAndFlush() {
        assertThrows(InvalidDataAccessApiUsageException::class.java) {
            topService.dataSourceTopTxFlush()
        }
    }

    @Test
    @Rollback(false)
    fun JpaTm_하위트랜잭션_REQUIREWS_NEW_saveAndFlush() {
        topService.jpaTopTxFlush()
    }

    @Test
    @Rollback(false)
    fun DataSourceTm_하위트랜잭션_REQUIREWS_NEW_save() {
        topService.dataSourceTopTx()
    }

    @Test
    @Rollback(false)
    fun JpaTm_하위트랜잭션_REQUIREWS_NEW_save() {
        topService.jpaTopTx()
    }

    @Test
    @Rollback(false)
    fun DataSourceTm_트랜잭션_saveAndFlush() {
        assertThrows(InvalidDataAccessApiUsageException::class.java) {
            topService.dataSourceTxFlush()
        }
    }
}