package example.day03;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

public class Exam2 {
    public static void main(String[] args) {
        Student s1 = new Student("유재석", 100, 50);
        Student s2 = new Student("김현수", 90, 90);

        s1.setKor(100);
        System.out.println(s1.getKor());
        System.out.println(s2.toString());

        // 6. 빌더 패턴 이용한 객체 생성
        Student s3 = Student.builder()
        .kor(100)
        .name("강호동")
        .math(95)
        .build();

        // 즉 ] new 생성자() vs 클래스명.build();
        // 클래스명.메소드명(): 메소드가 static이면 객체 필요없음
        System.out.println(s3);

    }
}


@NoArgsConstructor // 매개변수 없는 생성자 (자동) 생성
@AllArgsConstructor // 전체매개변수가 있는 생성자 (자동)생성
// @RequiredArgsConstructor // final 멤버변수의 생성자 (자동)생성
@Getter @ Setter
@ToString
@Data   // setter + getter + ToString + RequireQrgsConstructor 묶음
@EqualsAndHashCode // 객체내 멤버변수의 값 모두 비교 메소드 (자동)생성
@Builder    // 
class Student{
    private String name;
    private int kor;
    private int math;
}