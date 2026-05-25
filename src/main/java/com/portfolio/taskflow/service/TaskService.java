package com.portfolio.taskflow.service;

import com.portfolio.taskflow.dto.TaskCreateRequest;
import com.portfolio.taskflow.dto.TaskResponse;
import com.portfolio.taskflow.dto.TaskUpdateRequest;

import java.util.List;

public interface TaskService {
    List<TaskResponse> findAll();
    TaskResponse findById(long id);
    TaskResponse create(TaskCreateRequest request);
    TaskResponse update(Long id, TaskUpdateRequest request);
    TaskResponse markAsCompleted(Long id);
    void deleteById(Long id);
}
