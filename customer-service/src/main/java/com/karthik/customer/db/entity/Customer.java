package com.karthik.customer.db.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Table
@Entity
@Data
public final class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int age;
    private String name;

    public Customer(long id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public Customer() {

    }



}
