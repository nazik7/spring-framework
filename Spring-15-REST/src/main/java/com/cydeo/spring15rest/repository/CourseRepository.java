package com.cydeo.spring15rest.repository;

import com.cydeo.spring15rest.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findAllByCategory(String category);
}
