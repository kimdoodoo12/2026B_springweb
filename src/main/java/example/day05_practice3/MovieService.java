package example.day05_practice3;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import example.day05.TestDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;

    public boolean movieSave(MovieDto movieDto){
        MovieEntity movieEntity = movieDto.toEntity();
        movieRepository.save(movieEntity);

        if (movieEntity.getMovieid() >= 1){ return true;}
        return false;
    }

    public List<MovieDto> movieFindAll(){
        List<MovieEntity> entities = movieRepository.findAll();
        List<MovieDto> movieDtos = new ArrayList<>();

        entities.forEach((entity) -> {
            movieDtos.add(MovieDto.from(entity));
        });

        return movieDtos;
    }

    public MovieDto movieFind(int movieid){
        Optional<MovieEntity> optional = movieRepository.findById(movieid);

        if(optional.isPresent()){
            MovieEntity movieEntity = optional.get();

            return MovieDto.from(movieEntity);
        }
        return null;
    }

    @Transactional
    public boolean movieUpdate(MovieDto movieDto){
        Optional<MovieEntity> optional = movieRepository.findById(movieDto.getMovieid());

        if (optional.isPresent()){
            MovieEntity movieEntity = optional.get();
            movieEntity.setRating(movieDto.getRating());
            return true;
        }
        return false;
    }

    public boolean movieDelete(int movieid){

        Optional<MovieEntity> optional = movieRepository.findById(movieid);
        if(optional.isPresent()){
            movieRepository.deleteById(movieid);
            return true;
        }
        return false;
        
    }
}
