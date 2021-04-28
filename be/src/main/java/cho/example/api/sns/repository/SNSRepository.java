package cho.example.api.sns.repository;

import cho.example.api.sns.domain.SNS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  SNSRepository extends JpaRepository<SNS,Long> {
    
}
