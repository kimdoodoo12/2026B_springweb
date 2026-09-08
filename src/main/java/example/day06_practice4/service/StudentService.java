package example.day06_practice4.service;

import org.springframework.stereotype.Service;

import example.day06_practice4.model.dto.StudentDto;
import example.day06_practice4.model.entity.StudentEntity;
import example.day06_practice4.model.repository.StudentRepository;
import lombok.RequiredArgsConstructor;


@Service @RequiredArgsConstructor 
public class StudentService {
    private final StudentRepository studentRepository;

    public boolean save(StudentDto studentDto){
        StudentEntity entity = studentDto.toEntity();

        studentRepository.save(entity);

        if(entity.getStudentId() >= 1){
            return true;
        }
        return false;
    }

    public boolean delete(Integer studentId){
        StudentEntity entity = studentRepository.findById(studentId).get();

        if(entity.getStudentId() >= 1){
            studentRepository.deleteById(studentId);
            return true;
        }
        return false;
    }
}
