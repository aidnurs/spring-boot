package com.example.demo;

import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-18T14:47:21+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class TodoMapperImpl implements TodoMapper {

    @Override
    public TodoDto toDto(TodoEntity todoEntity) {
        if ( todoEntity == null ) {
            return null;
        }

        UUID id = null;
        String title = null;
        Boolean done = null;

        id = todoEntity.getId();
        title = todoEntity.getTitle();
        done = todoEntity.getDone();

        TodoDto todoDto = new TodoDto( id, title, done );

        return todoDto;
    }

    @Override
    public TodoEntity toEntity(TodoDto todoDto) {
        if ( todoDto == null ) {
            return null;
        }

        TodoEntity todoEntity = new TodoEntity();

        todoEntity.setId( todoDto.id() );
        todoEntity.setTitle( todoDto.title() );
        todoEntity.setDone( todoDto.done() );

        return todoEntity;
    }
}
