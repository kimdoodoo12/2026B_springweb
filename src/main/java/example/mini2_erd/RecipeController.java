package example.mini2_erd;

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

@RestController
@RequiredArgsConstructor
public class RecipeController {
    private final RecipeService recipeService;

    @GetMapping("/recipe")
    public List<RecipeDto> recipeFindAll(){
        return recipeService.findAll();
    }
    @GetMapping("/recipe/detail")
    public RecipeDto recipeFind(@RequestParam(name="recipeid") int recipeid){
        return recipeService.find(recipeid);
    }
    @PostMapping("/recipe")
    public boolean recipeSave(@RequestBody RecipeDto recipeDto){
        return recipeService.recipeSave(recipeDto);
    }
    @PutMapping("/recipe")
    public boolean recipeUpdate(@RequestBody RecipeDto recipeDto){
        return recipeService.recipeUpdate(recipeDto);
    }
    @DeleteMapping("/recipe/{recipeid}")
    public boolean recipeDelete(@PathVariable(name="recipeid") int recipeid){
        return recipeService.delete(recipeid);
    }
}
