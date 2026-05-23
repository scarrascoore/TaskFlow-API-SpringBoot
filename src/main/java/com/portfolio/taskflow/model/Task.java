package com.portfolio.taskflow.model;

import java.time.LocalDateTime;

public class Task {
    private Long id;
    private String title;
    private String description;
    private TaskStatus status;
    private LocalDateTime createAt;
    private LocalDateTime updatedAt;

    public Task(Long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = TaskStatus.PENDING;
        this.createAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    //METODO DE NEGOCIO
    public void update(String title, String description){
        this.title = title;
        this.description = description;
        this.updatedAt = LocalDateTime.now();
    }

    //METODO DE DOMINIO
    public void markAsComplete(){
        this.status = TaskStatus.COMPLETED;
        this.updatedAt = LocalDateTime.now();
    }

    // METODOS DE ACCESO
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
