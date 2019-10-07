package com.shj.todo.core.controller;

import com.shj.todo.core.entity.BaseEntity;
import com.shj.todo.core.service.BaseService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface BaseEntityController<T extends BaseEntity> {
    BaseService<T> service();

    @PostMapping("/create")
    @ApiOperation(value = "基础接口，创建实体")
    default RestResult create(@RequestBody T entity) {
        this.service().create(entity);
        return RestResult.builder()
                .code(RestResultCode.SUCCESS.getCode())
                .build();
    }

    @PutMapping("/update")
    @ApiOperation(value = "基础接口，修改实体")
    default RestResult update(@RequestBody T entity) {
        this.service().create(entity);
        return RestResult.builder()
                .code(RestResultCode.SUCCESS.getCode())
                .build();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "基础接口，根据ID获取实体")
    default RestResult get(@PathVariable String id) {
        this.service().getEntityById(id);
        return RestResult.builder()
                .code(RestResultCode.SUCCESS.getCode())
                .build();
    }

    @DeleteMapping("/{id}/delete")
    @ApiOperation(value = "基础接口，删除实体")
    default RestResult delete(@PathVariable String id) {
        this.service().delete(id);
        return RestResult.builder()
                .code(RestResultCode.SUCCESS.getCode())
                .build();
    }

    @GetMapping("/")
    @ApiOperation(value = "基础接口，获取全部实体")
    default RestResult getAll() {
        List<T> list = this.service().listAll();
        return RestResult.builder()
                .code(RestResultCode.SUCCESS.getCode())
                .result(list)
                .build();
    }
}
