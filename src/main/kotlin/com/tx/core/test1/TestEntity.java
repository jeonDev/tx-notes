package com.tx.core.test1;

import jakarta.persistence.*;

@Entity
@Table(name = "TEST")
public class TestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "NAME")
    private String name;

    public TestEntity(String name) {
        this.name = name;
    }

    public TestEntity() {
    }

}
