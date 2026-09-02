package example.day04_practice1;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@RestController
@RequestMapping("/test")
public class TestController {
    @PostMapping(("/"))
    public boolean testWrite(@RequestBody TestDto testDto){
        System.out.println("TestController.testWrite()");
        return true;
    }

    @GetMapping("/testPrint")
    public ArrayList<TestDto> testPrint(){

        TestDto testDto1 = new TestDto();
        testDto1.setContent("배고파");  testDto1.setWriter("김두현");
        TestDto testDto2 = new TestDto();
        testDto2.setContent("졸려");    testDto2.setWriter("김현수");
        ArrayList <TestDto> result = new ArrayList<>();
        
        result.add(testDto1);
        result.add(testDto2);
        return result;
    }

    @GetMapping("/detail")
    public TestDto testDetail(@RequestParam int id){

        TestDto testDto = new TestDto(1, "내용1", "작성자1");

        return testDto;
    }

    @DeleteMapping("/testDelete")
    public boolean testDelete(@RequestParam int id){

        return true;
    }

    @PutMapping("/testUpdate")
    public boolean testUpdate(@RequestBody TestDto testDto){

        System.out.println("TestController.testUpdate()");
        return true;
    }
}

@NoArgsConstructor
@AllArgsConstructor
@Data
class TestDto{
    private int id;
    private String content;
    private String writer;
}

/*
    - int 기본타입 21억 저장
    - Integer: 참조타입 (int 래퍼클래스) + null(없다) 저장
    주의할점: HTTP 파싱하는 경우에 int에는 null 저장 불가능
    권장1: 기본타입 대신에 래퍼타입 상 ㅛㅇ하자
 */