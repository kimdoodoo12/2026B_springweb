package example.practice5_ver2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import example.practice5_ver2.model.dto.BoardDto;
import example.practice5_ver2.service.BoardService;

@RestController 
public class BoardController {
    
    @Autowired private BoardService boardService;

    @PostMapping("/api/board")
    public boolean save(@RequestBody BoardDto boardDto){
        return boardService.save(boardDto);
    }

    @GetMapping("/api/board")
    public List<BoardDto> findAll(){
        return boardService.findAll();
    }

    @DeleteMapping ("/api/board")
    public void delete(@RequestParam(name="id") Integer id, @RequestParam (name="password") String password){
        boardService.delete(id, password);
    }
}
