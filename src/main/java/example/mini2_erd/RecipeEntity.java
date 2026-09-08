package example.mini2_erd;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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

/**
 * recipe : menu 와 product 를 잇는 교차 엔티티 (양쪽 다 @ManyToOne).
 * recipe_order 는 "메뉴 안에서의 순번"이라 전역 유일하지 않으므로
 * 별도 대리 PK(recipe_id, auto_increment)를 둔다.
 */
@Entity
@Table(name = "recipe")
@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor @Builder
public class RecipeEntity extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipe_id")
    private Integer recipeId;

    @Column(name = "recipe_order")
    private Integer recipeOrder;

    // ===== recipe(N) : menu(1) =====  주인(FK 보유)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_no")     // recipe.menu_no -> menu.menu_id
    @ToString.Exclude
    private MenuEntity menu;

    // ===== recipe(N) : product(1) =====  주인(FK 보유)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_no")  // recipe.product_no -> product.product_no
    @ToString.Exclude
    private ProductEntity product;
}
