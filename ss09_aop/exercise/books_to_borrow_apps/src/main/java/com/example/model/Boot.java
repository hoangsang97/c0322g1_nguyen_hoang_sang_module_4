package com.example.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Boot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private int amount;

    @OneToMany(mappedBy = "boot")
    private Set<OrderBorrow> orderBorrows;

    public Boot() {
    }

    public Boot(int id, String name, int amount) {
        this.id = id;
        this.name = name;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Set<OrderBorrow> getOrderBorrows() {
        return orderBorrows;
    }

    public void setOrderBorrows(Set<OrderBorrow> orderBorrows) {
        this.orderBorrows = orderBorrows;
    }
}
