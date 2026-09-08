package example.day06_practice4.service;

import org.springframework.stereotype.Service;

import example.day06_practice4.model.dto.CourseDto;
import example.day06_practice4.model.entity.CourseEntity;
import example.day06_practice4.model.repository.CourseRepository;
import lombok.RequiredArgsConstructor;

@Service @RequiredArgsConstructor 
public class CourseService {
    
    private final CourseRepository courseRepository;

    public boolean save(CourseDto courseDto){
        
        CourseEntity entity = courseDto.toEntity();

        if(entity.getCourseId() >= 1){
            courseRepository.save(entity);
            return true;
        }
        return false;
    }
}
