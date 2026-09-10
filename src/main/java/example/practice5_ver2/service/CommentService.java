package example.practice5_ver2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import example.practice5_ver2.model.dto.CommentDto;
import example.practice5_ver2.model.entity.BoardEntity;
import example.practice5_ver2.model.entity.CommentEntity;
import example.practice5_ver2.repository.BoardRepository;
import example.practice5_ver2.repository.CommentRepository;

@Service 
public class CommentService {
    
    @Autowired private CommentRepository commentRepository;
    @Autowired private BoardRepository boardRepository;


    public boolean save(CommentDto commentDto){
        CommentEntity commentEntity = commentDto.toEntity();
        BoardEntity boardEntity = boardRepository.findById(commentDto.getBoardId()).get();
        commentEntity.setBoardEntity(boardEntity);
        commentRepository.save(commentEntity);

        if(commentEntity.getCommentId() >= 1){
            return true;
        }
        return false;
    }

    public void delete(Integer commentId, String password){
        
        CommentEntity entity = commentRepository.findById(commentId).orElseThrow(() -> new IllegalArgumentException("can't find comment"));

        commentRepository.deleteById(commentId);
    }
}
