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
@Table(name = "product")
@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor @Builder
public class ProductEntity extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // product_no auto_increment
    @Column(name = "product_no")
    private Integer productNo;

    @Column(name = "product_name", length = 50)
    private String productName;

    @Column(name = "product_price")
    private Integer productPrice;

    // ===== product(1) : recipe(N) =====  주인 = RecipeEntity.product
    @OneToMany(mappedBy = "product")
    @ToString.Exclude
    @Builder.Default
    private List<RecipeEntity> recipeList = new ArrayList<>();

    // ===== product(1) : productlog(N) =====  주인 = ProductLogEntity.product
    @OneToMany(mappedBy = "product")
    @ToString.Exclude
    @Builder.Default
    private List<ProductLogEntity> productLogList = new ArrayList<>();

    // 연관관계 편의 메서드
    public void addRecipe(RecipeEntity recipe) {
        this.recipeList.add(recipe);
        recipe.setProduct(this);
    }

    public void addProductLog(ProductLogEntity productLog) {
        this.productLogList.add(productLog);
        productLog.setProduct(this);
    }
}
