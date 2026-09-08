package example.day06_practice4.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import example.day06_practice4.model.dto.EnrollDto;
import example.day06_practice4.service.EnrollService;
import lombok.RequiredArgsConstructor;

@RestController 
@RequiredArgsConstructor 
public class EnrollController {
    
    private final EnrollService enrollService;

    @PostMapping("/enroll")
    public boolean save(@RequestBody EnrollDto enrollDto){
        return enrollService.save(enrollDto);
    }

    @GetMapping ("/enroll")
    public List<EnrollDto> findAll(){
        return enrollService.findAll();
    }

    @GetMapping ("/enroll/detail")
    public EnrollDto find(@RequestParam(name="enrollId") Integer enrollId){
        return enrollService.find(enrollId);
    }

    @PutMapping ("/enroll")
    public boolean update(@RequestBody EnrollDto enrollDto){
        return enrollService.update(enrollDto);
    }
}
