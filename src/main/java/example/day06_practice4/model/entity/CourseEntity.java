package example.day06_practice4.model.entity;

import java.util.ArrayList;
import java.util.List;

import example.day06_practice4.BaseTime;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity @Table(name="course")
@Getter @Setter @ToString @Builder 
@NoArgsConstructor @AllArgsConstructor
public class CourseEntity extends BaseTime{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer courseId;

    @Column
    private String courseName;

    @OneToMany(mappedBy = "courseEntity" , cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    @ToString.Exclude
    @Builder.Default
    private List<EnrollEntity> eList = new ArrayList<>();

}
