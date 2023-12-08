package controller;

import dto.CourseDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.CourseService;

import java.util.List;

@Controller
@RestController// @Controller + @ResponseBody
@RequestMapping("/courses")
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

}
