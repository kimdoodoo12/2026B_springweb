package example.practice5_ver2.repository;

import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import example.practice5_ver2.model.entity.BoardEntity;
import java.util.List;


@Repository 
public interface BoardRepository extends JpaRepository<BoardEntity, Integer>{
    
    // 개별ㅈ회
    Map<Integer, Object> findByBoardId(Integer boardId);

    // 전체조회
    @Query(value="SELECT * FROM board", nativeQuery = true)
    List<Map<Integer, Object>> findAllBoard();
}
