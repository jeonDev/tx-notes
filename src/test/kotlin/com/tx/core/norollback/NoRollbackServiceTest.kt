package com.tx.core.norollback

import com.tx.core.CommonTestRepository
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.lang.Exception

@SpringBootTest
class NoRollbackServiceTest(
    @Autowired
    var noRollbackService: NoRollbackService,
    @Autowired
    var commonTestRepository: CommonTestRepository
) {

    @Test
    fun noRollback설정_하위_runtimeException_롤백안됨() {
        try {
            noRollbackService.noRollback()
        } catch (e:Exception) {

        }
        assertEquals(1, commonTestRepository.findAll().size)
    }
}