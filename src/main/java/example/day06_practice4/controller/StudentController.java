package example.day06_practice4.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import example.day06_practice4.model.dto.StudentDto;
import example.day06_practice4.service.StudentService;
import lombok.RequiredArgsConstructor;

@RestController @RequiredArgsConstructor 
public class StudentController {
    
    private final StudentService studentService;

    @PostMapping("/student")
    public boolean save(@RequestBody StudentDto studentDto){
        return studentService.save(studentDto);
    }

    @DeleteMapping("/student")
    public boolean delete(@PathVariable(name="studentId") Integer studentId){
        return studentService.delete(studentId);
    }
}
