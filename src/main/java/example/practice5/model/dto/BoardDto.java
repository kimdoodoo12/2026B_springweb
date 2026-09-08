package example.practice5.model.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import example.practice5.model.entity.BoardEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @Builder 
@NoArgsConstructor @AllArgsConstructor 
public class BoardDto {
    
    private Integer id;

    private String author;
    private String content;
    private String password;

    private List<CommentDto> comments; // 서비스로직에서?

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    public BoardEntity toEntity(){
        return BoardEntity.builder()
            .author(this.author)
            .content(this.content)
            .password(this.password)
            .build();
    }

    public static BoardDto from(BoardEntity entity){
        BoardDto boardDto = BoardDto.builder()
            .id(entity.getBoardId())
            .author(entity.getAuthor())
            .content(entity.getContent())
            .createdAt(entity.getCreatedAt())
            .updatedAt(entity.getUpdatedAt())
            .build();
        List<CommentDto> list = new ArrayList<>();
        entity.getCList().forEach((cEntity)->{
                list.add(CommentDto.from(cEntity));
            });
        boardDto.setComments(list);
        return boardDto;
    }
}
