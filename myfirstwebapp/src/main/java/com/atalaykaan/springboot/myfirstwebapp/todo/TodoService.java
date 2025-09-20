package com.atalaykaan.springboot.myfirstwebapp.todo;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoService {

    private static List<Todo> todos = new ArrayList<>();

    private static int todosCount = 0;

    static {

        todos.add(new Todo(++todosCount, "Kaan", "Java",
                LocalDate.now().plusYears(1), false));
        todos.add(new Todo(++todosCount, "Kaan", "Spring Boot"
                , LocalDate.now().plusYears(2), false));
        todos.add(new Todo(++todosCount, "Kaan", "Backend Development",
                LocalDate.now().plusYears(3), false));
        todos.add(new Todo(++todosCount, "Kaan", "DevOps",
                LocalDate.now().plusYears(4), false));
    }

    public List<Todo> findByUsername(String username) {

        Predicate<Todo> ifUsernameExists = (todo) -> todo.getUsername().equalsIgnoreCase(username);

        return todos.stream().filter(ifUsernameExists).toList();
    }

    public void addTodo(String username, String description, LocalDate localDate, boolean done) {

        todos.add(new Todo(++todosCount, username, description, localDate, done));
    }

    public void deleteById(int id) {

        Predicate<Todo> idExists = (todo) -> todo.getId() == id;

        todos.removeIf(idExists);
    }

    public Todo findById(int id) {

        Predicate<Todo> idExists = (todo) -> todo.getId() == id;

        return todos.stream().filter(idExists).findFirst().get();
    }

    public void updateTodo(@Valid Todo todo) {

        deleteById(todo.getId());

        todos.add(todo);
    }
}
