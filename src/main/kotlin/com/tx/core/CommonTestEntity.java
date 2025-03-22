package com.tx.core;

import jakarta.persistence.*;

@Entity
@Table(name = "COMMON_TEST")
public class CommonTestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public CommonTestEntity(String name) {
        this.name = name;
    }

    public CommonTestEntity() {
    }
}
