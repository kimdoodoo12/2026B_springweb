package example.practice5.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import example.practice5.model.dto.BoardDto;
import example.practice5.service.BoardService;
import lombok.RequiredArgsConstructor;

@RestController 
@RequiredArgsConstructor 
public class BoardController {
    private final BoardService boardService;
    
    @PostMapping("/api/board")
    public boolean save(@RequestBody BoardDto boardDto){
        return boardService.save(boardDto);
    }

    @GetMapping ("/api/board")
    public List<BoardDto> findAll(){
        return boardService.findAll();
    }

    @DeleteMapping("/api/board")
    public boolean delete(@RequestParam(name="id")Integer id, @RequestParam(name="password") String password){
        return boardService.delete(id, password);
    }
}
