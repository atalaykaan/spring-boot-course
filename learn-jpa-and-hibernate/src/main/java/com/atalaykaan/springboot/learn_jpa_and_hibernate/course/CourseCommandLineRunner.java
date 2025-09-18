package com.atalaykaan.springboot.learn_jpa_and_hibernate.course;

import com.atalaykaan.springboot.learn_jpa_and_hibernate.course.jdbc.CourseJdbcRepository;
import com.atalaykaan.springboot.learn_jpa_and_hibernate.course.jpa.CourseJpaRepository;
import com.atalaykaan.springboot.learn_jpa_and_hibernate.course.springdatajpa.CourseSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

//    ---------SPRING JDBC---------
//
//    private CourseJdbcRepository courseRepository;
//
//    @Autowired
//    public CourseCommandLineRunner(CourseJdbcRepository courseRepository) {
//
//        this.courseRepository = courseRepository;
//    }
//
//    ---------SPRING JPA---------
//
//    private CourseJpaRepository courseRepository;
//
//    @Autowired
//    public CourseCommandLineRunner(CourseJpaRepository courseRepository) {
//
//        this.courseRepository = courseRepository;
//    }
//
//    ---------SPRING DATA JPA---------

    private CourseSpringDataJpaRepository courseRepository;

    @Autowired
    public CourseCommandLineRunner(CourseSpringDataJpaRepository courseRepository) {

        this.courseRepository = courseRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        courseRepository.save(new Course(1, "Java ile Nesne Merkezli Programlama", "Akin"));
        courseRepository.save(new Course(2, "Spring", "in28minutes"));
        courseRepository.save(new Course(3, "Spring Boot", "Chad Darby"));
        courseRepository.save(new Course(4, "Azure JPA", "in28minutes"));

        courseRepository.deleteById(1L);

        System.out.println(courseRepository.findById(2L));
        System.out.println(courseRepository.findById(3L));;

//        System.out.println(courseRepository.findById(1L));

        System.out.println(courseRepository.findByAuthor("Akin"));
        System.out.println(courseRepository.findByAuthor("in28minutes"));
        System.out.println(courseRepository.findByAuthor("Chad Darby"));

        System.out.println(courseRepository.findByName("Spring"));

    }
}
