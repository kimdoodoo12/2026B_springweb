package example.mini2;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.criteria.CriteriaBuilder.In;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Entity @Table(name="recipe")
@Data @Builder
public class RecipeEntity {

    @Id
    @ManyToOne
    @JoinColumn(name="menu_id")
    private MenuEntity menuEntity;

    @Id
    private Integer recipe_order;

    @ManyToOne
    @JoinColumn(name="product_no")
    private ProductEntity productEntity;

}