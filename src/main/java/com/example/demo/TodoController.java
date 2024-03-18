package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/todo")
@RequiredArgsConstructor
public class TodoController {
  private final TodoService todoService;

  @GetMapping
  public List<TodoEntity> getAllTodos() {
    return todoService.getAllTodos();
  }

  @GetMapping("/:id")
  public TodoDto getTodoById(@PathVariable UUID id) {
    return todoService.getTodoById(id);
  }

  @PostMapping
  public TodoDto createTodo(@RequestBody TodoDto todoDto) {
    return todoService.createTodo(todoDto);
  }

  @DeleteMapping("/:id")
  public void deleteTodoById(@PathVariable UUID id) {
    todoService.deleteTodoById(id);
  }
}

