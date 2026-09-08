package example.mini2;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Entity @Table(name="product")
@Data @Builder
public class ProductEntity {
    
    @Id
    private Integer product_no;

    @Column
    private String product_name;

    @Column
    private Integer price;

    @OneToMany(mappedBy = "recipeEntity")
    @ToString.Exclude
    @Builder.Default
    private List<RecipeEntity> recipeList = new ArrayList<>();
}
