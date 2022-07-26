package com.example.model;

import javax.persistence.*;

@Entity
public class OrderBorrow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "boot_id", referencedColumnName = "id")
    private Boot boot;

    @ManyToOne
    @JoinColumn(name = "borrow_id", referencedColumnName = "id")
    private Borrow borrow;

    public OrderBorrow() {
    }

    public OrderBorrow(int id, Boot boot) {
        this.id = id;
        this.boot = boot;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boot getBoot() {
        return boot;
    }

    public void setBoot(Boot boot) {
        this.boot = boot;
    }

    public Borrow getBorrow() {
        return borrow;
    }

    public void setBorrow(Borrow borrow) {
        this.borrow = borrow;
    }
}
