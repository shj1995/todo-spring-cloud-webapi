package com.shj.todo.task.entity;


import com.shj.todo.core.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "task")
public class TaskEntity extends BaseEntity implements Serializable {

    @Id
    private String id;

    private String title;
}
