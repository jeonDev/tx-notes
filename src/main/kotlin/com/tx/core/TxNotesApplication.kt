package com.tx.core

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TxNotesApplication

fun main(args: Array<String>) {
    runApplication<TxNotesApplication>(*args)
}
