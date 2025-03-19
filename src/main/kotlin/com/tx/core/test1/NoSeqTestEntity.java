package com.tx.core.test1;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.context.annotation.Profile;

@Entity
@Table(name = "TEST1")
@Profile("test1")
public class NoSeqTestEntity {

    @Id
    private Long id;

    @Column(name = "NAME")
    private String name;

    public NoSeqTestEntity() {
    }

    public NoSeqTestEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
