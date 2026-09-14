package example.practice5_ver2.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import example.practice5_ver2.model.dto.BoardDto;
import example.practice5_ver2.model.entity.BoardEntity;
import example.practice5_ver2.repository.BoardRepository;

@Service 
public class BoardService {
    @Autowired BoardRepository boardRepository;


    public boolean save(BoardDto boardDto){
        BoardEntity boardEntity = boardDto.toEntity();
        boardRepository.save(boardEntity);

        if(boardEntity.getBoardId() >= 1){
            return true;
        }
        return false;
    }

    public List<BoardDto> findAll(){
        List<BoardEntity> boardEntities = boardRepository.findAll();

        List<BoardDto> boardDtos = boardEntities.stream().map(BoardDto::from).toList();
        return boardDtos;
    }

    public void delete(Integer id, String password){
        BoardEntity entity = boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("can't find board"));
        if(entity.getPassword().equals(password)){
            boardRepository.delete(entity);
        }
    }
}
