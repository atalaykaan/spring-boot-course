package com.atalaykaan.learn_spring_security.resources;

import com.atalaykaan.learn_spring_security.model.Todo;
import jakarta.annotation.security.RolesAllowed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableMethodSecurity(jsr250Enabled = true, securedEnabled = true)
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
    @PreAuthorize("hasRole('USER') and #username == authentication.name")
    @PostAuthorize("returnObject.getUsername() == 'kaan'")
    @RolesAllowed({"USER", "ADMIN"})
    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    public Todo retrieveTodosForSpecificUser(@PathVariable String username) {
        return TODOS_LIST.get(0);
    }

    @PostMapping("/users/{username}/todos")
    public void createTodoForUser(@PathVariable String username, @RequestBody Todo todo) {

        logger.info("Creating {} for {}", todo, username);
    }
}
