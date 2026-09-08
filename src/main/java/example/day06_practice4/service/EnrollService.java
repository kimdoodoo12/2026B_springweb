package example.day06_practice4.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import example.day06_practice4.model.dto.EnrollDto;
import example.day06_practice4.model.entity.EnrollEntity;
import example.day06_practice4.model.repository.CourseRepository;
import example.day06_practice4.model.repository.EnrollRepository;
import example.day06_practice4.model.repository.StudentRepository;
import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor 
public class EnrollService {
    
    private final EnrollRepository enrollRepository;
    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;


    public boolean save(EnrollDto enrollDto){
        EnrollEntity entity = enrollDto.toEntity();
        
        entity.setCourseEntity(courseRepository.findById(enrollDto.getCourseid()).get());
        entity.setStudentEntity(studentRepository.findById(enrollDto.getStudentId()).get());

        enrollRepository.save(entity);

        if (entity.getEnrollId() >= 1){
            return true;
        }
        return false;
    }
    
    public List<EnrollDto> findAll(){

        List<EnrollEntity> entities = new ArrayList<>();
        List<EnrollDto> enrollDtos = new ArrayList<>();

        entities = enrollRepository.findAll();

        entities.forEach((entity) -> {
            enrollDtos.add(EnrollDto.from(entity));
        });

        return enrollDtos;
    }

    public EnrollDto find(Integer enrollId){

        EnrollEntity entity = enrollRepository.findById(enrollId).get();

        return EnrollDto.from(entity);

    }

    public boolean update(EnrollDto enrollDto){

        Optional<EnrollEntity> optional = enrollRepository.findById(enrollDto.getEnrollId());

        if(optional.isPresent()){
            EnrollEntity entity = optional.get();
            entity.setStatus(enrollDto.getStatus());
            return true;
        }
        return false;
    }
}
