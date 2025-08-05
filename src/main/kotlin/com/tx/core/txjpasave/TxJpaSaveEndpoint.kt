package com.tx.core.txjpasave

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TxJpaSaveEndpoint(
    val txJpaSaveService: TxJpaSaveService
) {

    @PostMapping("/tx/1")
    fun datasource1() = txJpaSaveService.noTransactionSave()

    @PostMapping("/tx/2")
    fun datasource2() = txJpaSaveService.transactionSave()

}