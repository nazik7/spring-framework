package com.cydeo.repository;

import com.cydeo.entity.Course;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.stream.Stream;

public interface CourseRepository extends JpaRepository<Course, Long> {
    //find all courses by category
    List<Course> findByCategory(String category);

    //find all courses by category and order the entities by name
    List<Course> findByCategoryOrderByName(String category);

    //checks if a course with provided name exists
    boolean existsByName(String name);

    int countByCategory(String category);

    //find all courses that start with name
    List<Course> findByNameStartingWith(String pattern);

    //find all courses by category and returns stream
    Stream<Course> streamByCategory(String category);

}
