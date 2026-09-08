package example.mini2;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Entity @Table(name="menu")
@Data @Builder
public class MenuEntity {
    
    @Id
    @ManyToOne
    @JoinColumn(name="menu_id")
    private Integer menu_id;
    private MenuEntity menuEntity;
    
    @Column
    private String menu_name;
    @Column
    private Integer menu_price;

}
