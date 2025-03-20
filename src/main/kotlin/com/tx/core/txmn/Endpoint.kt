package com.tx.core.txmn

import org.springframework.context.annotation.Profile
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@Profile("txmn")
class Endpoint(
    val topService: TopService
) {

    @PostMapping("/datasource/1")
    fun datasource1() = topService.dataSourceTopTxFlush()

    @PostMapping("/datasource/2")
    fun datasource2() = topService.dataSourceTopTx()

    @PostMapping("/datasource/3")
    fun datasource3() = topService.dataSourceTopTx()

    @PostMapping("/jpa/1")
    fun jpa1() = topService.jpaTopTxFlush()

    @PostMapping("/jpa/2")
    fun jpa2() = topService.jpaTopTx()

}