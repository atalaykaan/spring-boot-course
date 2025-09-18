package com.atalaykaan.springboot.learn_jpa_and_hibernate.course.jdbc;

import com.atalaykaan.springboot.learn_jpa_and_hibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {

    private JdbcTemplate courseJdbcTemplate;

    private static String INSERT_QUERY =
            """
            insert into course(id, name, author)
            values(?, ?, ?);
            """;

    private static String DELETE_QUERY =
            """
            delete from course
            where id=?
            """;

    private static String SELECT_QUERY =
            """
            select * from course
            where id=?
            """;

    @Autowired
    public CourseJdbcRepository(JdbcTemplate courseJdbcTemplate) {

        this.courseJdbcTemplate = courseJdbcTemplate;
    }

    public void insert(Course course) {

        courseJdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
    }

    public void deleteById(long id) {
        courseJdbcTemplate.update(DELETE_QUERY, id);
    }

    public Course selectById(long id) {

        return courseJdbcTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class), id);
    }
}
