package example.day06;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity@Table(name="category")
@NoArgsConstructor@AllArgsConstructor@Builder@Data
public class CategoryEntity {
    @Id
    private int cno;

    private String cname;
    // 양방향 참조 , 비권장
    @OneToMany(mappedBy = "categoryEntity")  // 1 : M , mappedBy를 쓰지 않을 경우 DB에도 생성이 됨
    @ToString.Exclude   // 자바에서 양방향관계에서 순환참조 방지
    @Builder.Default    // 만일 해당 Entity가 빌더 패턴 사용시 초기값 그대로 사용
    private List<BoardEntity> boardList = new ArrayList<>();
}
