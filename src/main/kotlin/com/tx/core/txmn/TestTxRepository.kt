package com.tx.core.txmn

import org.springframework.context.annotation.Profile
import org.springframework.data.jpa.repository.JpaRepository

@Profile("txmn")
interface TestTxRepository:JpaRepository<TestTxEntity, Long> {
}