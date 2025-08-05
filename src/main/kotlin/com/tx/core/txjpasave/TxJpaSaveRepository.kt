package com.tx.core.txjpasave

import org.springframework.data.jpa.repository.JpaRepository

interface TxJpaSaveRepository: JpaRepository<TxJpaSave, Long> {
}