package com.example.demo;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Testcontainers
public class PostgreSQLContainerTest {
    @Autowired
    private TodoRepository todoRepository;
    @Autowired
    private WorkerRepository workerRepository;
    @Container
    public static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:15-alpine");

    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgres::getJdbcUrl);
        registry.add("spring.datasource.username", postgres::getUsername);
        registry.add("spring.datasource.password", postgres::getPassword);
    }


    @BeforeAll
    public static void beforeAll() {
        postgres.start();
    }

    @AfterAll
    public static void afterAll() {
        postgres.stop();
    }


    @Test
    public void testTrigger() {
        TodoEntity todo = new TodoEntity();
        todo.setTitle("test");
        todoRepository.save(todo);
        List<WorkerEntity> workers = workerRepository.findAll();
        assertEquals(1, workers.size());
    }
}
