package example.day02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 스프링: 프레임워크이므로 다양한 도구와 툴 제공
// @어노테이션: 코드에 추가석인 설명과 의미부여할 때 사용 (라벨/주석)
// 1. @SpringBootAplication: 1) 내장 톰캣 (자동)세팅 2) 서블릿(Controller/컴포넌트) 자동 등록

@SpringBootApplication
public class AppStart {
    public static void main(String[] args) {
        // 2. spring 실행, SpringBootApplication [x] SpringApplication [o]
        // SpringApplication.run(현재클래스명.class); 
        // 클래스.class : 클래스 메타정보(생성자/멤버변수/메소드) 반환
        // SpringApplication.run(springboot메타정보);
        SpringApplication.run(AppStart.class);
        // 3. ctrl + f5 실행, 주의할점 : 2개이상 실행 불가능
        // 4. 실행 확인 : http://localhost:8080
        
    }
}
