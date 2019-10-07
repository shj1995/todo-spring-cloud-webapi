package com.shj.todo.core.controller;

import com.shj.todo.core.entity.BaseEntity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RestResult<T extends BaseEntity> {
    private int code;
    private String description;
    private Object result;
}
