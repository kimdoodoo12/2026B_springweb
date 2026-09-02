package example.day04;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor    // final 멤버변수 생성자 자동생성
public class ExamController {
    // * 서비스 객체(주입) 불러오기
    private final ExamService examService; // Autowired를 쓸 수 있으나 final을 빼야한다.

    // [1] 전체조회
    @GetMapping("/day04/exam")
    public List<ExamEntity> findAll(){

        // 서비스 호출
        return examService.findAll();
    }

    // [2] 저장
    @PostMapping("/day04/exam")
    public boolean save(@RequestBody ExamEntity entity){
        
        // 서비스 호출
        return examService.save(entity);
    }

    // [3] 삭제
    @DeleteMapping("/day04/exam")
    public boolean delete(@RequestParam(name = "no") int no){
        // 서비스 호출
        return examService.delete(no);
    }

    // [4] 수정
    @PutMapping("/day04/exam")
    public boolean update(@RequestBody ExamEntity examEntity){
        return examService.update(examEntity);
    }
}
