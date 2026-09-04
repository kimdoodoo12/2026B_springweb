package example.day05_practice3;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="movie")
@Getter@Setter@ToString@Builder
@NoArgsConstructor@AllArgsConstructor
public class MovieEntity extends BaseTime{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer movieid;

    @Column
    private String title;

    @Column
    private Integer rating;

    @Column
    private String director;

    @Column
    private LocalDate releaseDate;
    
}
