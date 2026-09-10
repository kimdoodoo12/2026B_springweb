package example.day07;

import java.util.List;
import java.util.function.Function;

public class Exam4 {
    public static void main(String[] args) {
        // 메소드 레퍼런스: 람다식이 단순히 기존메소드만 호출하는 경우 간결하게 표현하는 방법
        // 1.
        // Integer.parseInt("문자") 문자 --> 정수변환 함수
        Function<String, Integer> function1 = (x) -> {return Integer.parseInt(x);};
        Function<String, Integer> fucntion2 = Integer::parseInt;
        System.out.println(fucntion2.apply("10"));
        // 2.
        List<String> names = List.of("유재석", "강호동", "신동엽", "서장훈");
            // 1) 일반 for문 
            // 2) 향상된 for문
            // 3) forEach문
            names.stream().forEach((name)-> {System.out.println(name);});
            // 4) 메소드참조는 메소드명 명시하고 () 소괄호 작성하지 않는다.
            names.stream().forEach(System.out::println);

        // 3. 이름 글자수 출력
        // 정통방식
        for(int index = 0; index < names.size()-1; index++){
            System.out.println(names.get(index).length());
        }

        // 스트림 방식
        names.stream().map((name) -> {return name.length();}).forEach((result) -> { System.out.println(result); });

        // 메소드 레퍼런스(참조) 방식
        names.stream().map(String::length).forEach(System.out::println);

    // 4. names리스트내 문자열/이름들을 각각 대입하여 Student객체를 만드시요

    List<Student> students = names.stream().map((name) -> {return new Student(name);}).toList();
    List<Student> students2 = names.stream().map(Student::new).toList() ;

    /*
        1. 클래스명::static 메소드명
        2. 인스턴스명::메소드명
        3. 클래스명::new

        JPA 서비스 구조 : entity --> dto 변환
        List<MemberDto> list = entityList.stream().map((entity) -> {return MemberDto.from(entity);}).toList();
        List<MemberDto> list = entityList.stream().map(MemberDto::from).toList();
     */
    }
}

class Student{
    private String name;
    public Student(String name){this.name = name;};

}