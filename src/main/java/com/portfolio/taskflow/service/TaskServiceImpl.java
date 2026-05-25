package com.portfolio.taskflow.service;

import com.portfolio.taskflow.dto.TaskCreateRequest;
import com.portfolio.taskflow.dto.TaskResponse;
import com.portfolio.taskflow.dto.TaskUpdateRequest;
import com.portfolio.taskflow.exception.TaskNotFoundException;
import com.portfolio.taskflow.model.Task;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class TaskServiceImpl implements TaskService{
    private final Map<Long, Task> tasks = new LinkedHashMap<>();
    private Long currentId = 1L;

    @Override
    public List<TaskResponse> findAll() {
        return tasks.values()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    @Override
    public TaskResponse findById(long id) {
        Task task = findTaskOrThrow(id);
        return toResponse(task);
    }

    @Override
    public TaskResponse create(TaskCreateRequest request) {
        Task task = new Task(currentId, request.title(), request.description());
        tasks.put(currentId, task);
        currentId++;
        return toResponse(task);
    }

    @Override
    public TaskResponse update(Long id, TaskUpdateRequest request) {
        Task task = findTaskOrThrow(id);
        task.update(request.title(), request.description());
        return toResponse(task);
    }

    @Override
    public TaskResponse markAsCompleted(Long id) {
        Task task = findTaskOrThrow(id);
        task.markAsCompleted();
        return toResponse(task);
    }

    @Override
    public void deleteById(Long id) {
        Task task = findTaskOrThrow(id);
        tasks.remove(task.getId());
    }

    private Task findTaskOrThrow(Long id){
        Task task = tasks.get(id);
        if (task == null){
            throw new TaskNotFoundException(id);
        }
        return task;
    }

    private TaskResponse toResponse(Task task){
        return new TaskResponse(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getStatus(),
                task.getCreateAt(),
                task.getUpdatedAt()
        );
    }
}
