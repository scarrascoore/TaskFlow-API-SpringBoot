# TaskFlow API Spring Boot

API REST para la gestión de tareas desarrollada con Java y Spring Boot.

## Objetivo

Este proyecto tiene como objetivo demostrar conocimientos base en desarrollo backend con Spring Boot, arquitectura por capas, DTOs, validaciones, manejo global de errores y buenas prácticas de código limpio.

## Tecnologías utilizadas

- Java 21
- Spring Boot
- Spring Web
- Jakarta Validation
- Maven
- Postman
- Git/GitHub

## Arquitectura

El proyecto utiliza una arquitectura por capas simple:

Controller → Service → Model / DTO / Exception

## Funcionalidades

- Crear tareas
- Listar tareas
- Buscar tarea por ID
- Actualizar tarea
- Marcar tarea como completada
- Eliminar tarea
- Manejar errores de validación
- Manejar errores cuando una tarea no existe

## Endpoints

| Método | Endpoint | Descripción |
|---|---|---|
| GET | /api/tasks | Lista todas las tareas |
| GET | /api/tasks/{id} | Busca una tarea por ID |
| POST | /api/tasks | Crea una tarea |
| PUT | /api/tasks/{id} | Actualiza una tarea |
| PATCH | /api/tasks/{id}/complete | Marca una tarea como completada |
| DELETE | /api/tasks/{id} | Elimina una tarea |

## Estructura del Proyecto

![EstructuraDelProyecto.png](docs/EstructuraDelProyecto.png)

## Autor

Proyecto desarrollado como parte de un portafolio profesional de desarrollo Backend Java / Full Stack Java.
