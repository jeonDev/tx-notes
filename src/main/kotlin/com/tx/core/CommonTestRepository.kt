package com.tx.core

import org.springframework.data.jpa.repository.JpaRepository

interface CommonTestRepository:JpaRepository<CommonTestEntity, Long> {
}