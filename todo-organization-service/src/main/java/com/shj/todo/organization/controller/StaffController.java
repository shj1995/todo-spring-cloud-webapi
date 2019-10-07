package com.shj.todo.organization.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/staff")
@Api("人员接口")
public class StaffController {

    @GetMapping("/{name}")
    public String hello(@PathVariable("name") String name) {
        return "hello " + name;
    }
}
