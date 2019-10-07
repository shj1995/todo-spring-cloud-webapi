package com.shj.todo.task.service.impl;

import com.shj.todo.core.repostory.BaseRepository;
import com.shj.todo.core.service.BaseService;
import com.shj.todo.task.entity.TaskEntity;
import com.shj.todo.task.repository.TaskRepository;
import com.shj.todo.task.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService implements ITaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public BaseRepository<TaskEntity> repository() {
        return this.taskRepository;
    }

}
