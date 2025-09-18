package com.atalaykaan.springboot.learn_jpa_and_hibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {

    private CourseJdbcRepository courseJdbcRepository;

    @Autowired
    public CourseJdbcCommandLineRunner(CourseJdbcRepository courseJdbcRepository) {

        this.courseJdbcRepository = courseJdbcRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        courseJdbcRepository.insert();
    }
}
