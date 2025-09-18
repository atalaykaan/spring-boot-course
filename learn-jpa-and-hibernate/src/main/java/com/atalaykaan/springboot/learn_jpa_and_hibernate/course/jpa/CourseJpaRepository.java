package com.atalaykaan.springboot.learn_jpa_and_hibernate.course.jpa;

import com.atalaykaan.springboot.learn_jpa_and_hibernate.course.Course;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class CourseJpaRepository {

    private EntityManager entityManager;

    public CourseJpaRepository() {

    }

    @Autowired
    public CourseJpaRepository(EntityManager entityManager) {

        this.entityManager = entityManager;
    }

    @Transactional
    public void insert(Course course) {

        entityManager.merge(course);
    }

    public Course selectById(long id) {

        return entityManager.find(Course.class, id);
    }

    @Transactional
    public void deleteById(long id) {

        Course course = entityManager.find(Course.class, id);

        entityManager.remove(course);
    }
}
