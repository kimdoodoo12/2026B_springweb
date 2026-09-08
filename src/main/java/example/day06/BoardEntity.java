package example.day06;

import java.util.ArrayList;
import java.util.List;

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
import lombok.ToString;

@Entity@Table(name="board")
@NoArgsConstructor@AllArgsConstructor@Builder@Data
public class BoardEntity {
    @Id
    private int bno;

    private String bname;

    // 단방향 참조 FK , 자바에서는 멤버변수가 Entity이지만 DB에서는 fk만 저장
    @ManyToOne // M : 1
    @JoinColumn(name="cno") // 주로 PK와 동일하게
    private CategoryEntity categoryEntity;

    // 양방향 참조 (거울 쪽) : ReplyEntity.boardEntity 필드가 관계의 주인
    @OneToMany(mappedBy = "boardEntity" , cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    @ToString.Exclude       // 순환참조 방지
    @Builder.Default
    private List<ReplyEntity> replyList = new ArrayList<>();
}
