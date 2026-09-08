package example.practice5.model.entity;

import java.util.ArrayList;
import java.util.List;

import example.practice5.model.BaseTime;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity @Table(name="board")
@Getter @Setter @ToString @Builder 
@NoArgsConstructor @AllArgsConstructor 
public class BoardEntity extends BaseTime{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer boardId;

    @Column
    private String author;

    @Column
    private String password;

    @Column
    private String content;

    @OneToMany(mappedBy = "boardEntity", cascade = CascadeType.ALL)
    @ToString.Exclude
    @Builder.Default
    private List<CommentEntity> cList = new ArrayList<>();
}
