package example.practice5.model.dto;

import java.time.LocalDateTime;

import example.practice5.model.entity.CommentEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @Builder 
@NoArgsConstructor @AllArgsConstructor 
public class CommentDto {
    private Integer boardId;
    private Integer id;

    private String author;
    private String content;

    private String password;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public CommentEntity toEntity(){
        return CommentEntity.builder()
            .commentId(this.id)
            .author(this.author)
            .content(this.content)
            .password(this.password)
            .build();
    }

    public static CommentDto from(CommentEntity entity){
        return CommentDto.builder()
            .boardId(entity.getBoardEntity().getBoardId())
            .id(entity.getCommentId())
            .author(entity.getAuthor())
            .content(entity.getContent())
            .createdAt(entity.getCreatedAt())
            .updatedAt(entity.getUpdatedAt())
            .build();
    }
}
