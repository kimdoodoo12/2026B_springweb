package example.day06_practice4.model.dto;

import java.time.LocalDateTime;

import example.day06_practice4.model.entity.EnrollEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor 
@Builder 
public class EnrollDto {
    
    private Integer enrollId;

    private String status;

    private Integer courseid;
    private String courseName;

    private Integer studentId;
    private String studentName;

    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    public EnrollEntity toEntity(){
        return EnrollEntity.builder()
            .status(status)
            .build();   // 서비스쪽에서 courseId 와 studentId를 초기화해야함
    }

    public static EnrollDto from(EnrollEntity entity){
        return EnrollDto.builder()
                .enrollId(entity.getEnrollId())
                .status(entity.getStatus())
                .courseName(entity.getCourseEntity().getCourseName())
                .studentName(entity.getStudentEntity().getStudentName())
                .createDate(entity.getCreateDate())
                .updateDate(entity.getUpdateDate())
                .build();
    }
    
}
