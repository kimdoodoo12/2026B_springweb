package example.day04_practice2;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController // @Controller(+@Component) + @ResponseBody
public class TestController {
    
    private final TestService testService;

    @PostMapping("/day04_practice2/test")
    public boolean testWrite(@RequestBody TestEntity testEntity){
        return testService.testWrite(testEntity);
    }

    @GetMapping("/day04_practice2/test")
    public List<TestEntity> testPrint(){
        List<TestEntity> testEntities = testService.testPrint();
        return testEntities;
    }

    @GetMapping("/day04_practice2/test/detail")
    public TestEntity testDetail(@RequestParam(name = "no") int no){
        return testService.testDetail(no);
    }

    @DeleteMapping("/day04_practice2/test/{no}")
    public boolean testDelete(@PathVariable(name="no") int no){
        return testService.testDelete(no);
    }

    @PutMapping("/day04_practice2/test")
    public boolean testUpdate(@RequestBody TestEntity testEntity){
        return testService.testUpdate(testEntity);
    }
}
