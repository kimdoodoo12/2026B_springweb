package example.practice5.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import example.practice5.model.dto.BoardDto;
import example.practice5.model.entity.BoardEntity;
import example.practice5.repository.BoardRepository;
import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor 
public class BoardService {
    private final BoardRepository boardRepository;

    public boolean save(BoardDto boardDto){
        
        BoardEntity entity = boardDto.toEntity();

        boardRepository.save(entity);
        if(entity.getBoardId() >= 1){
            return true;
        }
        return false;
    }

    public List<BoardDto> findAll(){

        List<BoardEntity> entities = new ArrayList<>();
        List<BoardDto> boardDtos = new ArrayList<>();

        entities = boardRepository.findAll();

        entities.forEach((entity) ->{
            boardDtos.add(BoardDto.from(entity));
        });
        return boardDtos;
    }

    public boolean delete(Integer id, String password){
        Optional<BoardEntity> optional = boardRepository.findById(id);

        if(optional.isPresent()){
            BoardEntity entity = optional.get();
            // 비밀번호가 맞는 경우
            if(password.equals(entity.getPassword())){
                boardRepository.deleteById(id);
                return true;
            }
            // 비밀번호가 맞지 않는 경우
            return false;
        }
        // 게시글 id가 존재하지 않는 경우
        return false;
    }
}
