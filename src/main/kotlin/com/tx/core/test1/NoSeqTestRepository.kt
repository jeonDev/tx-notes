package com.tx.core.test1

import org.springframework.context.annotation.Profile
import org.springframework.data.jpa.repository.JpaRepository

@Profile("test1")
interface NoSeqTestRepository:JpaRepository<NoSeqTestEntity, Long> {
}