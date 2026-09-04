package example.day05_practice3;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter@Setter@ToString
@NoArgsConstructor@AllArgsConstructor@Builder
public class MovieDto {
    private Integer movieid;
    private String title;
    private String director;
    private LocalDate releaseDate;
    private Integer rating;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    public MovieEntity toEntity(){
        return MovieEntity.builder()
                .title(this.title)
                .rating(this.rating)
                .director(this.director)
                .releaseDate(this.releaseDate)
                .build();

    }

    public static MovieDto from(MovieEntity movieEntity){
        return MovieDto.builder()
            .movieid(movieEntity.getMovieid())
            .title(movieEntity.getTitle())
            .rating(movieEntity.getRating())
            .releaseDate(movieEntity.getReleaseDate())
            .createDate(movieEntity.getCreateDate())
            .updateDate(movieEntity.getUpdateDate())
            .build();
    }
}
