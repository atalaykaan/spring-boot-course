package com.atalaykaan.springboot.learn_jpa_and_hibernate.course.jdbc;

import com.atalaykaan.springboot.learn_jpa_and_hibernate.course.Course;
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

        courseJdbcRepository.insert(new Course(1, "Java ile Nesne Merkezli Programlama", "Akın"));
        courseJdbcRepository.insert(new Course(2, "Spring", "in28minutes"));
        courseJdbcRepository.insert(new Course(3, "Spring Boot", "Chad Darby"));

        courseJdbcRepository.deleteById(1);

        System.out.println(courseJdbcRepository.selectById(2));
        System.out.println(courseJdbcRepository.selectById(3));;

//        System.out.println(courseJdbcRepository.selectById(1));
    }
}
