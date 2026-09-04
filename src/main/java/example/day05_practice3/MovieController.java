package example.day05_practice3;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class MovieController {
    
    private final MovieService movieService;

    @PostMapping("/movie")
    public boolean movieSave(@RequestBody MovieDto movieDto){
        return movieService.movieSave(movieDto);
    }

    @GetMapping("/movie")
    public List<MovieDto> movieFindAll(){
        return movieService.movieFindAll();
    }

    @GetMapping("/movie/detail/{movieid}")
    public MovieDto movieFind(@PathVariable(name="movieid") int movieid){
        return movieService.movieFind(movieid);
    }

    @PutMapping("/movie")
    public boolean movieUpdate(@RequestBody MovieDto movieDto){
        return movieService.movieUpdate(movieDto);
    }

    @DeleteMapping("/movie")
    public boolean movieDelete(@RequestParam(name="movieid") int movieid){
        return movieService.movieDelete(movieid);
    }
}
