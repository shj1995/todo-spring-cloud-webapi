package com.shj.todo.core.controller;

import lombok.Data;

public enum RestResultCode {
    SUCCESS(200, "调用成功"),
    FAILURE(500, "系统异常");

    RestResultCode(int code, String description) {
        this.code = code;
        this.description = description;
    }
    private int code;
    private String description;
    public int getCode(){
        return this.code;
    }
    public String getDescription(){
        return this.description;
    }
}
