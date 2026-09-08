package example.mini2_erd;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository <ProductEntity, Integer>{
    
}
