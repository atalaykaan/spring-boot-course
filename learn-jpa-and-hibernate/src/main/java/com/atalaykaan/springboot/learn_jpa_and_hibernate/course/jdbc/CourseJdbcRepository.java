package com.atalaykaan.springboot.learn_jpa_and_hibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {

    private JdbcTemplate courseJdbcTemplate;

    private static String INSERT_QUERY =
            """
            insert into course(id, name, author)
            values(1, 'spring boot course', 'in28minutes');
            """;

    @Autowired
    public CourseJdbcRepository(JdbcTemplate courseJdbcTemplate) {

        this.courseJdbcTemplate = courseJdbcTemplate;
    }

    public void insert() {

        courseJdbcTemplate.update(INSERT_QUERY);
    }
}
