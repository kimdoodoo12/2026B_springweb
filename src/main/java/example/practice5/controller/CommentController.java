package example.practice5.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import example.practice5.model.dto.CommentDto;
import example.practice5.service.CommentService;
import lombok.RequiredArgsConstructor;

@RestController 
@RequiredArgsConstructor 
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/api/board/comments")
    public boolean save(@RequestBody CommentDto commentDto){
        return commentService.save(commentDto);
    }

    @DeleteMapping("/api/board/comments")
    public boolean delete(@RequestParam(name="commentId") Integer commentId, @RequestParam(name="password") String password){
        return commentService.delete(commentId, password);
    }
}
