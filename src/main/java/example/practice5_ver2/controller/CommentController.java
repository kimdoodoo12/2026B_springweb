package example.practice5_ver2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import example.practice5_ver2.model.dto.CommentDto;
import example.practice5_ver2.service.CommentService;

@RestController 
public class CommentController {

    @Autowired private CommentService commentService;
    
    @PostMapping("/api/board/comments")
    public boolean save(@RequestBody CommentDto commentDto){
        return commentService.save(commentDto);
    }

    @DeleteMapping("/api/board/comments")
    public void delete(@RequestParam(name="commentId") Integer commentId, @RequestParam(name="password") String password){
        commentService.delete(commentId, password);
    }
}
