package com.shj.todo.task.controller;

import com.shj.todo.core.controller.BaseEntityController;
import com.shj.todo.core.service.BaseService;
import com.shj.todo.task.entity.TaskEntity;
import com.shj.todo.task.service.ITaskService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/task")
@Api(value = "/api/task", description = "任务接口")
public class TaskController implements BaseEntityController<TaskEntity> {

    private final ITaskService taskService;

    @Autowired
    public TaskController(ITaskService taskService) {
        this.taskService = taskService;
    }

    @Override
    public BaseService<TaskEntity> service() {
        return this.taskService;
    }


}
