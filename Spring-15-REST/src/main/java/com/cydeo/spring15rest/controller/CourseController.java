package com.cydeo.spring15rest.controller;

import com.cydeo.spring15rest.dto.CourseDTO;
import com.cydeo.spring15rest.service.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController// @Controller + @ResponseBody
@RequestMapping("/courses/api/v1")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<CourseDTO> getAllCourses(){
        List<CourseDTO> courseDTOList = courseService.getCourses();
        return courseDTOList;
    }

    @GetMapping("{id}")
    public CourseDTO getCourseById(@PathVariable("id")Long courseId){
        return courseService.getCourseById(courseId);
    }
    @GetMapping("category/{name}")
    public List<CourseDTO> getCourseBYCategory(@PathVariable("name")String category){
        return courseService.getCoursesByCategory(category);
    }
    @PostMapping
    public CourseDTO createCourse(@RequestBody CourseDTO course){
        return courseService.createCourse(course);
    }

    @PutMapping("{id}")
    public void updateCourse(@PathVariable("id") Long courseId,@RequestBody CourseDTO courseDTO){
        courseService.updateCourse(courseId,courseDTO);
    }

    @DeleteMapping("{id}")
    public void deleteCourseById(@PathVariable("id")Long courseId){
        courseService.deleteCourseById(courseId);
    }

    @DeleteMapping
    public void deleteCourses(){
        courseService.deleteCourses();
    }

}
