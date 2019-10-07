package com.shj.todo.core.entity;

import javax.persistence.Column;
import javax.persistence.Id;

public abstract class BaseEntity {

    @Id
    @Column(length = 32)
    public String id;

    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id = id;
    }

}

