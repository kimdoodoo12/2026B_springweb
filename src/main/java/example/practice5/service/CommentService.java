package example.practice5.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import example.practice5.model.dto.CommentDto;
import example.practice5.model.entity.BoardEntity;
import example.practice5.model.entity.CommentEntity;
import example.practice5.repository.BoardRepository;
import example.practice5.repository.CommentRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor  
public class CommentService {
    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;

    public boolean save(CommentDto commentDto){
        CommentEntity entity = commentDto.toEntity();
        BoardEntity boardEntity = boardRepository.findById(commentDto.getBoardId()).get();

        if(boardEntity.getBoardId() >= 1){
            entity.setBoardEntity(boardEntity);
            commentRepository.save(entity);
            return true;
        }
        return false;
    }

    public boolean delete(Integer commentId, String password){

        Optional<CommentEntity> optional = commentRepository.findById(commentId);

        if(optional.isPresent()){
            CommentEntity entity = optional.get();
            if(password.equals(entity.getPassword())){
                commentRepository.deleteById(commentId);
                return true;
            }
            // 비밀번호가 맞지 않는 경우
            return false;
        }
        // 게시글 id가 맞지 않는 경우
        return false;

    }
}
