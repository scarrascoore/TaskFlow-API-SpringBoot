package com.portfolio.taskflow.exception;

import java.time.LocalDateTime;
import java.util.List;

public record ErrorResponse(
        LocalDateTime timestamp,
        int Status,
        String error,
        List<String> messages,
        String path
) {
}
