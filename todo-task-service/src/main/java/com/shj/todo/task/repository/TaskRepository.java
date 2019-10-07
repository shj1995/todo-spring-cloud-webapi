package com.shj.todo.task.repository;

import com.shj.todo.core.repostory.BaseRepository;
import com.shj.todo.task.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends BaseRepository<TaskEntity> {
}
