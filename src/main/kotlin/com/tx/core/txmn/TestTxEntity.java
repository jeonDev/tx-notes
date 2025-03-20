package com.tx.core.txmn;

import jakarta.persistence.*;

@Entity
@Table(name = "TEST_TX")
public class TestTxEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "NAME")
    private String name;

    public TestTxEntity(String name) {
        this.name = name;
    }

    public TestTxEntity() {
    }

}
