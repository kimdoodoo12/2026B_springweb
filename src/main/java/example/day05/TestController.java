package example.day05;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class TestController {
    
    @Autowired private TestService testService;

    @GetMapping("/test")
    public List<TestDto> testPrint(){
        return testService.testPrint();
    }

    @PostMapping("/test")
    public boolean testSave(@RequestBody TestDto testDto){
        return testService.testSave(testDto);
    }

    @PutMapping("/test")
    public boolean testUpdate(@RequestBody TestDto testDto){
        return testService.testUpdate(testDto);
    }
}
