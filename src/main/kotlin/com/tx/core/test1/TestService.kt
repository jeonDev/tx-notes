package com.tx.core.test1

import jakarta.persistence.EntityManager
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Profile("test1")
class TestService(
    val testRepository: TestRepository,
    val noSeqTestRepository: NoSeqTestRepository,
    val em: EntityManager
) {

    @Transactional
    fun transactionSavePersist() {
        println("============")
        val entity = TestEntity("ABC")
        testRepository.save(entity)
        println("============")
        val list = testRepository.findAll()
        println("============")
        println("size : " + list.size)
        /***
         * ============
         * Hibernate: select next value for test_seq
         * ============
         * Hibernate: insert into test (name,id) values (?,?)
         * Hibernate: select te1_0.id,te1_0.name from test te1_0
         * ============
         * size : 1
         */
    }

    @Transactional
    fun transactionNoSequenceSavePersist() {
        println("============")
        val entity = NoSeqTestEntity(1L, "ABC")
        noSeqTestRepository.save(entity);
        println("============")
        val list = noSeqTestRepository.findAll()
        println("============")
        println("size : " + list.size)
        /***
         * ============
         * Hibernate: select nste1_0.id,nste1_0.name from test1 nste1_0 where nste1_0.id=?
         * ============
         * Hibernate: insert into test1 (name,id) values (?,?)
         * Hibernate: select nste1_0.id,nste1_0.name from test1 nste1_0
         * ============
         * size : 1
         *
         */
    }

    @Transactional
    fun transactionPersist() {
        println("============")
        val entity = TestEntity("ABC")
        em.persist(entity)
        println("============")
        val find = em.find(TestEntity::class.java, 1L)
        println("============")
        println("entity : " + find.toString())
        /**
         * ============
         * Hibernate: select next value for test_seq
         * ============
         * Hibernate: select te1_0.id,te1_0.name from test te1_0 where te1_0.id=?
         * ============
         * entity : com.tx.core.test1.TestEntity@11703cc8
         * Hibernate: insert into test (name,id) values (?,?)
         *
         */
    }

    @Transactional
    fun transactionPersistFlush() {
        println("============")
        val entity = TestEntity("ABC")
        em.persist(entity)
        em.flush()
        println("============")
        val find = em.find(TestEntity::class.java, 1L)
        println("============")
        println("entity : " + find.toString())
        /**
         * ============
         * Hibernate: insert into test (name,id) values (?,?)
         * ============
         * Hibernate: select te1_0.id,te1_0.name from test te1_0 where te1_0.id=?
         * ============
         * entity : com.tx.core.test1.TestEntity@6b5c4b75
         *
         */
    }

    @Transactional
    fun transactionNoSeqPersist() {
        println("============")
        val entity = NoSeqTestEntity(2L, "ABC")
        em.persist(entity)
        println("============")
        val find = em.find(NoSeqTestEntity::class.java, 1L)
        println("============")
        println("entity : " + find.toString())
        /**
         * ============
         * ============
         * Hibernate: select nste1_0.id,nste1_0.name from test1 nste1_0 where nste1_0.id=?
         * ============
         * entity : com.tx.core.test1.NoSeqTestEntity@6ade4ac6
         * Hibernate: insert into test1 (name,id) values (?,?)
         *
         */
    }

    @Transactional
    fun transactionNoSeqPersistFlush() {
        println("============")
        val entity = NoSeqTestEntity(1L, "ABC")
        em.persist(entity)
        em.flush()
        println("============")
        val find = em.find(NoSeqTestEntity::class.java, 1L)
        println("============")
        println("entity : " + find.toString())
        /**
         * ============
         * Hibernate: insert into test1 (name,id) values (?,?)
         * ============
         * ============
         * entity : com.tx.core.test1.NoSeqTestEntity@6079d219
         *
         */
    }

    fun noTransactionPersist() {
        println("============")
        val entity = TestEntity("ABC")
        em.persist(entity)
        println("============")
        val find = em.find(TestEntity::class.java, 1L)
        println("============")
        println("entity : " + find.toString())
        /**
         * persist -> TransactionRequiredException
         */
    }
    
}