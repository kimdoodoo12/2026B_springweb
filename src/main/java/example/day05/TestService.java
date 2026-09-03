package example.day05;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;


@Service
public class TestService {
    
    @Autowired private TestRepository testRepository;

    public List<TestDto> testPrint(){
        // 1. 모든 엔티티 조회한다.
        List<TestEntity> entities = testRepository.findAll();
        List<TestDto> list = new ArrayList<>();

        // 리스트.forEach((반복변수) -> { });
        entities.forEach((entity) -> {
            TestDto testDto = TestDto.from(entity);
            list.add(testDto);
        });

        return list;
    }

    public boolean testSave(TestDto testDto){
        TestEntity testEntity = testDto.toEntity();

        TestEntity savedEntity = testRepository.save(testEntity);

        if (savedEntity.getNo() >= 1 ){return true;}
        return false;
    }

    @Transactional
    public boolean testUpdate(TestDto testDto){
        Optional<TestEntity> optional = testRepository.findById(testDto.getNo());
        // 2. 찾은 엔티티가 존재하면
        if (optional.isPresent()){
            TestEntity entity = optional.get();

            entity.setName(testDto.getName());
            entity.setPrice(testDto.getPrice());
            entity.setDescription(testDto.getDescription());

            return true;
        }
        return false;
    }
}
