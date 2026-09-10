package example.practice5_ver2.model.dto;

import java.time.LocalDateTime;
import java.util.List;

import example.practice5_ver2.model.entity.BoardEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @Builder 
@AllArgsConstructor @NoArgsConstructor 
public class BoardDto {
    private Integer id;
    private String author;
    private String content;
    private String password;
    private List<CommentDto> comments;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public BoardEntity toEntity(){
        return BoardEntity.builder()
            .boardId(this.id)
            .author(this.author)
            .content(this.content)
            .password(this.password)
            .build();
    }

    public static BoardDto from(BoardEntity boardEntity){
        return BoardDto.builder()
            .id(boardEntity.getBoardId())
            .author(boardEntity.getAuthor())
            .content(boardEntity.getContent())
            .comments(boardEntity.getComments().stream().map(CommentDto::from).toList())
            .createdAt(boardEntity.getCreatedAt())
            .updatedAt(boardEntity.getUpdatedAt())
            .build();
    }
}
