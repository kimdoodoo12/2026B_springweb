package example.practice5_ver2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import example.practice5_ver2.model.entity.BoardEntity;

@Repository 
public interface BoardRepository extends JpaRepository<BoardEntity, Integer>{
    
}
