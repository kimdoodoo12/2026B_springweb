package example.day07;

import java.util.Comparator;
import java.util.List;

public class Exam3 {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // 1. 컬렉션(List/Set/Map) 순회
            // 1) 일반 for문
            for(int index = 0; index <= numbers.size()-1; index++){
                System.out.println(numbers.get(index));
            }
            // 2) 향상된 for문
            for(Integer data: numbers){
                System.out.println(data);
            }
            // 3) forEach
            numbers.forEach((e) -> {System.out.println(e);});
        
        // 2. 스트림 API , 리스트객체.stream().중간연산1().중간연산2().최종연산();
            // 1) stream().forEach((순회변수명) -> {실행문}) , return 없는 단순 순회 제공
            numbers.stream().forEach((data) -> {System.out.println(data);});
            // 2) stream().map((순회변수명) -> {return 값;}).최종연산(); , return 있는 순회 제공
            List<Integer> newList = numbers.stream().map((data) -> {return data;}).toList();
            // 3) stream().filter((순회변수명) -> {return 조건식; } ).최종연산
            List<Integer> newList2 = numbers.stream().filter((data)-> {return data % 2 == 0;}).toList();
            // 4) stream().sorted().최종연산() , 오름차순 정렬, Comparator.reverseOrder() 내림차순 정렬
            List<Integer> newList3 = numbers.stream().sorted(Comparator.reverseOrder()).toList();
            // 5) stream().distinct().최종연산() , 중복제거
            List<Integer> newList4 = numbers.stream().distinct().toList();
            // 6) stream().limit().최종연산 , 개수만큼 반환
            List<Integer> newList5 = numbers.stream().limit(3).toList();

            // 7) 중간연산은 여러번 가능 , 최종연산은 1번 가능 , builder()
            List<Integer> newList6 = numbers.stream()
                                    .distinct()
                                    .filter((x) -> {return x % 2 == 0;})    // 조건식 (중간연산)
                                    .map((x) -> {return x;})                // 반환 (중간연산)
                                    .sorted(Comparator.reverseOrder())      // 정렬 (중간연산)
                                    .limit(3)                       // 반환개수 제한 (중간연산)
                                    .toList();                              // 리스트로반환 (최종연산)

            System.out.println(newList6);   // [10, 8, 6]
            // ** JPA에서 entity <--> DTO 변환 과정

            // 스트림이란? 컬렌션(리스트) 인스턴스를 흐름단위로 중간연산과 최종연산 제공 API
            // 메소드레퍼런스 API: 미리 만들어진 메소드들을 간편하게 호출하는 방법 제공 API
            // System.out.println("메소드호출 정석"); -> System.out::println("메소드호출 레퍼런스 방식");
    }
}
