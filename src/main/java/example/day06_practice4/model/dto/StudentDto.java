package example.day06_practice4.model.dto;

import java.time.LocalDateTime;

import example.day06_practice4.model.entity.StudentEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @Builder 
@NoArgsConstructor @AllArgsConstructor 
public class StudentDto {
    private Integer studentId;

    private String studentName;

    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    public StudentEntity toEntity(){
        return StudentEntity.builder()
                .studentName(this.studentName)
                .build();
    }

    public StudentDto from(StudentEntity entity){
        return StudentDto.builder()
                .studentId(entity.getStudentId())
                .studentName(entity.getStudentName())
                .createDate(entity.getCreateDate())
                .updateDate(entity.getUpdateDate())
                .build();
    }
}
