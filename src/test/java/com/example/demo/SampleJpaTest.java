package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;

import static org.junit.Assert.assertEquals;

@DataJpaTest
public class SampleJpaTest {
    @Autowired
    TodoRepository todoRepository;

    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.flyway.enabled", () -> false);
        registry.add("spring.jpa.properties.hibernate.dialect", () -> "org.hibernate.dialect.H2Dialect");
        registry.add("spring.jpa.hibernate.ddl-auto", () -> "create-drop");
        registry.add("spring.jpa.show-sql", () -> true);
    }

    @Test
    public void injectedComponentsAreNotNull() {
        var cnt = todoRepository.count();
        assert (cnt == 0);
    }

    @Test
    public void testSaveAndFindByTitle() {
        TodoEntity todo = new TodoEntity();
        todo.setTitle("test");
        todoRepository.save(todo);
        TodoEntity found = todoRepository.findByTitle("test");
        assert (found != null);
        assertEquals(todo.getTitle(), found.getTitle());
    }
}
