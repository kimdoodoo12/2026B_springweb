package example.day04;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service    // 비즈니스 로직 담당하는 객체(빈) 등록
@RequiredArgsConstructor
public class ExamService {
    // Repository 객체 (주입) 불러오기
    private final ExamRepository examRepository;

    public List<ExamEntity> findAll(){
        
        // Repository 호출
        // Repository 객체.findAll() : 구현체 select 지원
        return examRepository.findAll();
    }

    public boolean save(ExamEntity entity){

        // Repository 호출
        // Repository 객체.save(저장할 entity) : insert SQL 지원
        // save반환값은 영속(매핑/저장)된 엔티티 반환
        ExamEntity saved = examRepository.save(entity);
        // 즉 save된 엔티티가 PK가 존재하면 저장 성공
        if (saved.getEno() >= 1) return true;
        return false;
    }

    // [3] 삭제
    public boolean delete(int no){
        //Repository 호출
        // Repository객체.deleteById(삭제할 PK번호)
        // 반환타입: 없음, 삭제 여부 find
        examRepository.deleteById(no);

        return true;
    }

    @Transactional  // 트랜재션이란? 여러개 SQL 하나의 단위로 묶음
    // 만약에 여러개 SQL중에 하나라도 SQL 오류이면 전체 ROLLBACK 모두 성공하면 COMMIT
    // 활용처: 게좌이체, 회원가입포인트, 2개이상 기능을 하나로 묶음
    // [4] 수정
    public boolean update(ExamEntity examEntity){

        // Optional 클래스란? 본문 감싼 클래스(왜? null 예외 안전하게 사용)

        Optional<ExamEntity> entity = examRepository.findById(examEntity.getEno());

        if(entity.isPresent()){
            ExamEntity savedEntity = entity.get();

            savedEntity.setEname(examEntity.getEname());
            return true;
        }
        return false;
    }
}
