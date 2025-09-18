package com.atalaykaan.springboot.learn_jpa_and_hibernate.course;

import com.atalaykaan.springboot.learn_jpa_and_hibernate.course.jdbc.CourseJdbcRepository;
import com.atalaykaan.springboot.learn_jpa_and_hibernate.course.jpa.CourseJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

//    private CourseJdbcRepository courseRepository;
//
//    @Autowired
//    public CourseCommandLineRunner(CourseJdbcRepository courseRepository) {
//
//        this.courseRepository = courseRepository;
//    }

    private CourseJpaRepository courseRepository;

    @Autowired
    public CourseCommandLineRunner(CourseJpaRepository courseRepository) {

        this.courseRepository = courseRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        courseRepository.insert(new Course(1, "Java ile Nesne Merkezli Programlama", "Akın"));
        courseRepository.insert(new Course(2, "Spring", "in28minutes"));
        courseRepository.insert(new Course(3, "Spring Boot", "Chad Darby"));

        courseRepository.deleteById(1);

        System.out.println(courseRepository.selectById(2));
        System.out.println(courseRepository.selectById(3));;

//        System.out.println(courseRepository.selectById(1));
    }
}
