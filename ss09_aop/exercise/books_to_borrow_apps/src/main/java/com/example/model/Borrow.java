package com.example.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Borrow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String idBorrow;

    @OneToMany(mappedBy = "borrow")
    private Set<OrderBorrow> orderBorrows;

    public Borrow() {
    }

    public Borrow(int id, String idBorrow, Set<OrderBorrow> orderBorrows) {
        this.id = id;
        this.idBorrow = idBorrow;
        this.orderBorrows = orderBorrows;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdBorrow() {
        return idBorrow;
    }

    public void setIdBorrow(String idBorrow) {
        this.idBorrow = idBorrow;
    }

    public Set<OrderBorrow> getOrderBorrows() {
        return orderBorrows;
    }

    public void setOrderBorrows(Set<OrderBorrow> orderBorrows) {
        this.orderBorrows = orderBorrows;
    }
}
