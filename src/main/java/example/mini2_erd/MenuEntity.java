package example.mini2_erd;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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

@Entity
@Table(name = "menu")
@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor @Builder
public class MenuEntity extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // menu_id auto_increment
    @Column(name = "menu_id")
    private Integer menuId;

    @Column(name = "menu_name", length = 50)
    private String menuName;

    @Column(name = "menu_price")
    private Integer menuPrice;

    // ===== menu(1) : recipe(N) =====  거울 쪽. 주인 = RecipeEntity.menu
    @OneToMany(mappedBy = "menu")
    @ToString.Exclude
    @Builder.Default
    private List<RecipeEntity> recipeList = new ArrayList<>();

    // 연관관계 편의 메서드
    public void addRecipe(RecipeEntity recipe) {
        this.recipeList.add(recipe);
        recipe.setMenu(this);
    }
}
