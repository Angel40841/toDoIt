package com.example.todoit.model;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntity {
    @Id
    private long id;

    public long getId() {
        return id;
    }
}
