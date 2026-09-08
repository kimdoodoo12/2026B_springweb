package example.mini2_erd;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RecipeService {
    private final RecipeRepository recipeRepository;
    private final ProductRepository productRepository;
    private final MenuRepository menuRepository;

    public List<RecipeDto> findAll(){
        List<RecipeEntity> list = recipeRepository.findAll();
        List<RecipeDto> recipeDtos = new ArrayList<>();

        list.forEach((entity) -> {
            recipeDtos.add(RecipeDto.from(entity));
        });
        return recipeDtos;
    }
    public RecipeDto find(int recipeid){
        RecipeEntity recipeEntity = recipeRepository.findById(recipeid).get();

        RecipeDto recipeDto = RecipeDto.from(recipeEntity);

        return recipeDto;
    }

    public boolean recipeSave(RecipeDto recipeDto){

        RecipeEntity entity = recipeDto.toEntity();     
        
        ProductEntity productEntity = productRepository.findById(recipeDto.getProductNo()).get();
        MenuEntity menuEntity = menuRepository.findById(recipeDto.getMenuNo()).get();
        
        entity.setProduct(productEntity);
        entity.setMenu(menuEntity);

        recipeRepository.save(entity);
        if(entity.getRecipeId() >= 1){return true;}
        return false;

    }

    public boolean recipeUpdate(RecipeDto recipeDto){

        RecipeEntity recipeEntity = recipeRepository.findById(recipeDto.getRecipeId()).get();

        if(recipeEntity.getRecipeId() >= 1){
            recipeEntity.setRecipeOrder(recipeDto.getRecipeOrder());
            return true;
        }
        return false;
    }

    public boolean delete(int recipeid){

        RecipeEntity recipeEntity = recipeRepository.findById(recipeid).get();

        if(recipeEntity.getRecipeId() >= 1){
            recipeRepository.delete(recipeEntity);
            return true;
        }
        return false;
    }
}
