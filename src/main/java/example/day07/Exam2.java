package example.day07;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

interface Calculator{int plus(int x, int y);}
public class Exam2 {

    public static void main(String[] args) {
        // 1. 구현체: 추상메소드(인터페이스) 구현한 객체
        // 2. 익명구현체: 추상메소드 구현한 클래스 없이 직접(일회성) 구현
        // 인터페이스 변수명 = new 인터페이스() {추상 메소드 구현};
        Calculator calc = new Calculator() {
            @Override
            public int plus(int x, int y) {
                return x + y;
            }
        };

        // 3. 람다표현식
        Calculator clac2 = (x, y) -> x + y; // 같은 코드
        int reuslt2 = clac2.plus(3, 5);
        // 3. 람다표현식 사용하는 인터페이스
        // ** 제네릭이란? 클래스/인터페이스 내 사용할 타입을 정한다.
        // List<제네릭타입> , 즉 List에 저장할 타입이 dto
        // Function<인수타입, 반환타입> , apply(인수) , 매개변수o / 반환o
        Function<Integer , Integer> function = (x) -> {return x * 2;};
        System.out.println(function.apply(3));
        // Supplier<반환타입> , get(), 매개변수x / 반환o
        Supplier<Integer> supplier = ( ) -> {return 2;};
        System.out.println(supplier.get());

        // Cosumer<인수타입> , accept(인수) , 매개변수 o / 반환 x
        Consumer<String> consumer = (str) -> {System.out.println(str);};
        consumer.accept("WSG");

        // Predicate<인수타입> , test(인수) , 매개변수o / 반환(true/false)
        Predicate<Integer> predicate = (x) -> {return x % 2 == 0;};
        boolean result = predicate.test(3);

        // 활용처: 위 4가지 직접적인 사용이 아닌 API(남이만든 클래스/메소드)에서 활용가능
        // forEach -> Consumer , map -> Function , filter -> predicate  , findById
        // 즉 스트림API 주로 사용한다. 스프링시큐리티API

    }
}
