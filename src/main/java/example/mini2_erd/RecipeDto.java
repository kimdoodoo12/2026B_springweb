package example.mini2_erd;

import java.time.LocalDateTime;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Builder
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter @ToString 

public class RecipeDto {

    private Integer recipeId;
    private Integer menuNo;
    private Integer productNo;
    private Integer recipeOrder;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public RecipeEntity toEntity(){
        return RecipeEntity.builder()
                .recipeId(this.recipeId)
                .recipeOrder(this.recipeOrder)
                .build();
    }

    public static RecipeDto from(RecipeEntity recipeEntity){
        return RecipeDto.builder()
            .recipeId(recipeEntity.getRecipeId())
            .recipeOrder(recipeEntity.getRecipeOrder())
            .menuNo(recipeEntity.getMenu().getMenuId())
            .productNo(recipeEntity.getProduct().getProductNo())
            .createdAt(recipeEntity.getCreateDate())
            .updatedAt(recipeEntity.getUpdateDate())
            .build();
    }
}
