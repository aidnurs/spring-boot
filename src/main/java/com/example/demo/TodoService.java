package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TodoService {

  private final TodoRepository todoRepository;
  private final TodoMapper todoMapper;

  public List<TodoEntity> getAllTodos() {
    return todoRepository.findAll();
  }

  public TodoDto getTodoById(UUID id) {
    return todoMapper.toDto(todoRepository.findById(id).orElse(null));
  }

  public TodoDto createTodo(TodoDto todoDto) {
    return todoMapper.toDto(todoRepository.save(todoMapper.toEntity(todoDto)));
  }

  public void deleteTodoById(UUID id) {
    todoRepository.deleteById(id);
  }
}
