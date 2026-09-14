package example.totalpractice1.model.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity @Table(name="product")
@Getter @Setter @ToString @Builder 
@NoArgsConstructor @AllArgsConstructor 
public class ProductEntity {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bno;

    @Column
    private String name;

    @Column 
    private Integer price;

    @OneToMany(mappedBy = "productEntity")
    @Builder.Default
    @ToString.Exclude
    List<ReviewEntity> reviewEntities = new ArrayList<>();
    
}
