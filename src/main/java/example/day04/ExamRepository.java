package example.day04;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamRepository extends JpaRepository<ExamEntity, Integer>{
    // 구현체란? 해당 인터페이스(추상) 구현한 객체
    // < 제네릭 타입 > 이란? 해당 클래스내 사용할 매개타입
    // JpaRepository <조작할 엔티티명, 엔티티PK타입>
    
}
