package com.atalaykaan.springboot.learn_spring_boot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CourseController {

    @RequestMapping("/courses")
    private List<Course> retrieveAllCourses() {

        List<Course> courses = Arrays.asList(
                new Course(1, "Java", "Akın Kaldıroğlu"),
                new Course(2, "Spring Boot", "in28minutes"),
                new Course(3, "Spring", "Chad Darby")
        );

        return courses;
    }
}
