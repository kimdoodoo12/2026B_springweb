package example.day02.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import example.day02.model.dao.BoardDao;
import example.day02.model.dto.BoardDto;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;


/*
    컨트롤러에 서블릿(HTTP 프로토콜 사용 가능하게 기능/방법(GET/POST/PUT/DELETE) 제공하는 클래스) 기능달기
    * Legacy(과거) 코드는 상속받아 서블릿 구현
    * 스프링은 @Controller 내 서블릿 포함
    // 1. 웹기술 포함한 컨트롤러 클래스 위에 @Controller 또는 반환타입이 JSON이면 @RestController
    *HTTP content type: http를 통해 데이터 받은 곳에서 데이터 사용하는 타입/규칙/가이드/안내
    text/html, application/json, form 등등

    // 2. 해당 메소드마다 URL 정의
        * URL 정의시 http://127.0.0.1:8080(도메인) 이후 경로 정의
        1. PostMapping("/URL") : HTTP 메소드중에 POST 메소드 매핑/연결/대응 어노테이션
 */


@RestController
public class BoardController {
    private BoardController(){};
    private static final BoardController instance = new BoardController();
    public static BoardController getInstance(){return instance;}
    private BoardDao bd = BoardDao.getInstance();

    
 	
    // [1] 등록 Controller
    @PostMapping("/board/save") // HTTP 메소드중에 GET 메소드 매핑/연결/대응
    public boolean save( BoardDto boardDto ){
        boolean result = bd.save( boardDto ); // view에게 전달받은 매개변수을 dao에게전달
        return result; // dao에게 받은 결과을 view 반환
    }

    @GetMapping("/board/findAll")
    public ArrayList<BoardDto> findAll(){
        ArrayList<BoardDto> result = bd.findAll();
        return result;
    }

    @PutMapping("/board/update")
    public boolean update(int no, String content){
        boolean result = bd.update(no, content);
        return result;
    }

    @DeleteMapping("/board/delete")
    public boolean delete(int no){
        boolean result = bd.delete(no);
        return result;
    }
    
    
    
    

}
    
