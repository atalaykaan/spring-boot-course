package com.atalaykaan.rest.webservices.restful_web_services.user;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.util.function.Predicate;

@Service
public class UserDaoService {

    private static List<User> users = new ArrayList<>();

    private static int userCount = 0;

    static {

        users.add(new User(++userCount, "Kaan", LocalDate.now().minusYears(22)));
        users.add(new User(++userCount, "Ali", LocalDate.now().minusYears(30)));
        users.add(new User(++userCount, "Mehmet", LocalDate.now().minusYears(25)));
    }

    public List<User> findAll() {

        return users;
    }

    public User findUser(int id) {

        Predicate<User> checkIfUserWithIdExists = (user) -> user.getId() == id;

        return users.stream().filter(checkIfUserWithIdExists).findFirst().orElse(null);
    }

    public User save(User user) {

        user.setId(++userCount);

        users.add(user);

        return user;
    }

    public void deleteById(int id) {

        Predicate<User> checkIfUserWithIdExists = (user) -> user.getId() == id;

        users.removeIf(checkIfUserWithIdExists);
    }
}
