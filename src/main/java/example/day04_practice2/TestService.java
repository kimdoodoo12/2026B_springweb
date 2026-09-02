package example.day04_practice2;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;


@Transactional
@RequiredArgsConstructor
@Service
public class TestService {
    
    private final TestRepository testRepository;

    public boolean testWrite(TestEntity testEntity){
        TestEntity savedEntity = testRepository.save(testEntity);

        if(savedEntity.getNo() >= 1) return true;
        return false;
    }

    public List<TestEntity> testPrint(){
        List<TestEntity> testEntities = testRepository.findAll();
        return testEntities;
    }

    public TestEntity testDetail(int no){
        Optional<TestEntity> entity = testRepository.findById(no);
        
        if(entity.isPresent()){
            TestEntity selectedEntity = entity.get();
            return selectedEntity;
        }
        return null;
    }

    public boolean testDelete(int no){
        testRepository.deleteById(no);
        Optional<TestEntity> entity = testRepository.findById(no);

        if(!entity.isPresent()){
            return true;
        }
        return false;
    }

    public boolean testUpdate(TestEntity testEntity){
        Optional<TestEntity> entity = testRepository.findById(testEntity.getNo());

        if(entity.isPresent()){
            TestEntity savedEntity = entity.get();

            savedEntity.setContent(testEntity.getContent());
            return true;
        }
        return false;
    }
}
