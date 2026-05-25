package com.portfolio.taskflow.controller;

import com.portfolio.taskflow.dto.TaskCreateRequest;
import com.portfolio.taskflow.dto.TaskResponse;
import com.portfolio.taskflow.dto.TaskUpdateRequest;
import com.portfolio.taskflow.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<List<TaskResponse>> findAll() {
        return ResponseEntity.ok(taskService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponse> findById(@PathVariable("id") Long taskId) {
        return ResponseEntity.ok(taskService.findById(taskId));
    }

    @PostMapping
    public ResponseEntity<TaskResponse> create(@Valid @RequestBody TaskCreateRequest request) {
        TaskResponse response = taskService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskResponse> update(
            @PathVariable("id") Long taskId,
            @Valid @RequestBody TaskUpdateRequest request
    ) {
        return ResponseEntity.ok(taskService.update(taskId, request));
    }

    @PatchMapping("/{id}/complete")
    public ResponseEntity<TaskResponse> markAsCompleted(@PathVariable("id") Long taskId) {
        return ResponseEntity.ok(taskService.markAsCompleted(taskId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long taskId) {
        taskService.deleteById(taskId);
        return ResponseEntity.noContent().build();
    }
}