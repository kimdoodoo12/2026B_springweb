package example.day06_practice4.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import example.day06_practice4.model.dto.CourseDto;
import example.day06_practice4.service.CourseService;
import lombok.RequiredArgsConstructor;

@RestController @RequiredArgsConstructor 
public class CourseController {

    private final CourseService courseService;
    
    @PostMapping("/course")
    public boolean save(@RequestBody CourseDto courseDto){
        return courseService.save(courseDto);
    }
}
