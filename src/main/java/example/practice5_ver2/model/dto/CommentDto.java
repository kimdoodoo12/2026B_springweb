package example.practice5_ver2.model.dto;

import java.time.LocalDateTime;

import example.practice5_ver2.model.entity.CommentEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @Builder 
@NoArgsConstructor @AllArgsConstructor 
public class CommentDto {
    private Integer id;
    private Integer boardId;
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
            // boardId는?
            .build();
    }

    public static CommentDto from(CommentEntity commentEntity){
        return CommentDto.builder()
            .id(commentEntity.getCommentId())
            .boardId(commentEntity.getBoardEntity().getBoardId())
            .author(commentEntity.getAuthor())
            .content(commentEntity.getContent())
            .createdAt(commentEntity.getCreatedAt())
            .updatedAt(commentEntity.getUpdatedAt())
            .build();
    }
}
