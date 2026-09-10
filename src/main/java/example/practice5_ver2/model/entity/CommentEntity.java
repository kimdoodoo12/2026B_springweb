package example.practice5_ver2.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity @Table(name = "comment")
@Getter @Setter @ToString @Builder 
@NoArgsConstructor @AllArgsConstructor 
public class CommentEntity extends Basetime{
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commentId;

    @Column
    private String author;

    @Column
    private String content;

    @Column 
    private String password;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private BoardEntity boardEntity;

}
