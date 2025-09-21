package com.atalaykaan.rest.webservices.restful_web_services.user;

import com.atalaykaan.rest.webservices.restful_web_services.user.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserResource {

    private UserDaoService userDaoService;

    @Autowired
    public UserResource(UserDaoService userDaoService) {

        this.userDaoService = userDaoService;
    }

    @GetMapping("/users")
    public List<User> showAllUsers() {

        return userDaoService.findAll();
    }

    @GetMapping("/users/{id}")
    public User showSingleUser(@PathVariable int id) {

        User user = userDaoService.findUser(id);

        if(user == null) {

            throw new UserNotFoundException("id: " + id);
        }

        return user;
    }

    @PostMapping("/users")
    public ResponseEntity<User> createNewUser(@RequestBody User user) {

        User savedUser = userDaoService.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
