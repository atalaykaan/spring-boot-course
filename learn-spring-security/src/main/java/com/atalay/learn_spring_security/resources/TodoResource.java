package com.atalay.learn_spring_security.resources;

import com.atalay.learn_spring_security.model.Todo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoResource {

    private Logger logger = LoggerFactory.getLogger(TodoResource.class);

    private static final List<Todo> TODOS_LIST = List.of(
            new Todo("kaan", "learn spring"),
            new Todo("kaan", "learn java"));

    @GetMapping("/todos")
    public List<Todo> retrieveAllTodos() {

        return TODOS_LIST;
    }

    @GetMapping("/users/{username}/todos")
    public Todo retrieveTodoForUser(@PathVariable() String username) {

        return TODOS_LIST.get(0);
    }

    @PostMapping("/users/{username}/todos")
    public void createTodoForUser(@PathVariable String username, @RequestBody Todo todo) {

        logger.info("Creating {} for {}", todo, username);
    }
}
