package example.day07;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class Exam1 {
    public static void main(String[] args) {

        // 서로 다른 클래스의 메소드 호출 하는 방법
        // 메소드란? 상호작용 (2개 이상의 개체 주고(인수) 받는 (리턴))
        // 1. 인스턴스 생성하여 메소드 호출
        // TestService testService = new TestService();
        // int result = testService.plus(3, 5);


        // // 2. 싱글톤
        // TestService testService2 = TestService.getInstance();
        // int result2 = testService2.plus(3, 5);
        

        // 3. 메소드가 static이면
        int reuslt3 = TestService.plus2(3, 5);

        // // 4. 스프링 방식: @Service(자동인스턴스 생성)@Autowired(인스턴스 호출)
        // @Autowired private TestService testService2;
        // testService2.plus(10, 5);

        List<Student> list = new ArrayList<>();
        list.add(new Student("he"));
        list.add(new Student("she"));


    }
}
class Student{
    String name;
    Student(String name){this.name = name;}
    void eat(){
        System.out.println(this.name + "'s eating");
    }
}

class TestService{

    private TestService(){}
    private static final TestService instance = new TestService();
    public static TestService getInstance(){return instance;}

    int plus (int x , int y){
        return x + y;
    }

    static int plus2(int x, int y){
        return x + y;
    }

    
}