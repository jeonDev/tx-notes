package com.tx.core.txjpasave

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class TxJpaSaveService(
    val txJpaSaveRepository: TxJpaSaveRepository
){
    /**
     * 이건 OSIV : true 일 때만 insert 쿼리 실행
     * false 일 경우, 무반응
     */
    fun noTransactionSave() {
        txJpaSaveRepository.save(TxJpaSave("ABC"));
    }

    /**
     * 이건 OSIV 여부 상관 없이 insert 쿼리 실행
     */
    @Transactional(value = "jpaTransactionManager")
    fun transactionSave() {
        txJpaSaveRepository.save(TxJpaSave("ABC"));
    }
}