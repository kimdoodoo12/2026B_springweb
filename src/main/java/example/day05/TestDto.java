package example.day05;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor@AllArgsConstructor@Builder
@Setter@Getter@ToString
public class TestDto {  // 서로 계층간 이동객체 (Controller에서는 엔티티 사용금지)
    // Entity와 동일하게 멤버변수 구성: 기능별로 DTO 구성 예) 등록 DTO , 조회 DTO, 수정 DTO
    private Integer no;
    private String name;
    private String description;
    private Integer price;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;


    // DTO ---> ENTITY 함수 : Controller -> Service (DTO -> Entity) , toEntity( ) , 주로 save/update 목적
    public TestEntity toEntity(){
        return TestEntity.builder() // 빌더패턴이란? new(생성자) 대신에 객체 생성을 메소드 방식 지원
            .name(this.name)
            .description(this.description)
            .price(this.price)
            .build();
    }

    // ENTITY ---> DTO 함수 : Service -> Controller (Entity -> DTO) , from(Entity) , 주로 find
    public static TestDto from (TestEntity testEntity){
        return TestDto.builder()
            .no(testEntity.getNo())
            .name(testEntity.getName())
            .description(testEntity.getDescription())
            .price(testEntity.getPrice())
            .createDate(testEntity.getCreateDate())
            .updateDate(testEntity.getUpdateDate())
            .build();
    }
    
}
