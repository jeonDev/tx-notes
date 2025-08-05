package com.tx.core.txjpasave;

import jakarta.persistence.*;

@Entity
@Table(name = "TX_JPA_SAVE")
public class TxJpaSave {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String abc;

    public TxJpaSave(String abc) {
        this.abc = abc;
    }

    protected TxJpaSave() {
    }
}
