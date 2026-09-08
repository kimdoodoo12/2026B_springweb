package example.day06_practice4.model.entity;

import example.day06_practice4.BaseTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity @Table(name="enroll")
@Getter @Setter @ToString @Builder 
@NoArgsConstructor @AllArgsConstructor
public class EnrollEntity extends BaseTime{
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer enrollId;

    @Column
    private String status;

    @ManyToOne 
    @JoinColumn(name="course_id")
    private CourseEntity courseEntity;

    @ManyToOne 
    @JoinColumn(name="student_id")
    private StudentEntity studentEntity;

}
