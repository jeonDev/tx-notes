package com.tx.core.txmn

import jakarta.persistence.EntityManagerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.jdbc.datasource.DataSourceTransactionManager
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.transaction.PlatformTransactionManager
import javax.sql.DataSource

@Configuration
@Profile("txmn")
class TransactionConfig {

    @Bean
    fun transactionManager(dataSource:DataSource):PlatformTransactionManager {
        return DataSourceTransactionManager(dataSource)
    }

    @Bean
    fun jpaTransactionManager(emf: EntityManagerFactory):PlatformTransactionManager {
        return JpaTransactionManager(emf)
    }
}