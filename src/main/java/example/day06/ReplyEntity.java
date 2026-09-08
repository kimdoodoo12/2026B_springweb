package example.day06;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity@Table(name="reply")
@NoArgsConstructor@AllArgsConstructor@Builder@Data
public class ReplyEntity {
    @Id
    private Integer rno;

    private String rname;

    // 단방향 참조 (FK 주인) : reply.bno -> board.bno
    @ManyToOne(cascade = CascadeType.REMOVE , fetch = FetchType.LAZY)
    @JoinColumn(name="bno")
    private BoardEntity boardEntity;

}

/*

    - Entity entity = new Entity(); // 객체
    - repository.save( ) , repository.findAll( ) , repository.findById( ) 등등 결과 영속된 Entity 반환
    - 즉] respository.save(비영속 Entity)

    @ManyToOne(cascade = 영속성제약조건 , fetch = 불러오는 시기)
    - CascadeType
    CascadeType.REMOVE : 만일 부모 엔티티가 삭제되면 자식 엔티티 같이 삭제된다.
    CascadeType.MERGE : 만일 부모 엔티티가 수정되면 자식도 엔티티 수정
    CascadeType.DETACH : 만일 부모 엔티티가 영속해제되면 자식 엔티티도 해제
    CascadeType.REFRESH : 만일 부모 엔티티가 재호출(갱신)되면 자식도 같이 재호출(갱신)
    CascadeType.PERSIST : 만약 부모 엔티티가 저장하면 자식도 같이 저장
    CascadeType.All : 위의 설정 전부 다

    -FetchType
    FetchType.LAZY : 해당 엔티티 조회시 자식(참조) 엔티티 불러오지 않는다.
        - 초기 로딩 빠르다. 재사용성 느리다. 필요한 정보만 불러온다. <지연로딩>
    FetchType.EAGER : 해당 엔티티 조회시 자식(참조) 엔티티를 불러온다. - 부모조회시 자식(손자)도 포함
        - 기본값 , 초기 로딩 느리다. 재사용성 빠르다.

 */