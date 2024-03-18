package com.example.demo;

import java.io.Serializable;
import java.util.UUID;

/**
 * DTO for {@link TodoEntity}
 */
public record TodoDto(
        UUID id,
        String title,
        Boolean done) implements Serializable {
}