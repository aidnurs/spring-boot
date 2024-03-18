package com.example.demo;

import org.mapstruct.Mapper;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface TodoMapper {
  TodoDto toDto(TodoEntity todoEntity);
  TodoEntity toEntity(TodoDto todoDto);
}
