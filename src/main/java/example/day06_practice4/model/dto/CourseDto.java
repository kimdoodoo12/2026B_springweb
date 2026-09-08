package example.day06_practice4.model.dto;

import java.time.LocalDateTime;

import example.day06_practice4.model.entity.CourseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseDto {
    private Integer courseId;

    private String courseName;

    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    public CourseEntity toEntity() {
        return CourseEntity.builder()
                .courseName(this.courseName)
                .build();
    }

    public CourseDto from(CourseEntity entity) {
        return CourseDto.builder()
                .courseId(entity.getCourseId())
                .courseName(entity.getCourseName())
                .createDate(entity.getCreateDate())
                .updateDate(entity.getUpdateDate())
                .build();
    }
}
