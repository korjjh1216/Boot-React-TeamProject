package cho.example.api.qnaboard.repository;

import cho.example.api.qnaboard.domain.QnA;
import org.springframework.data.jpa.repository.JpaRepository;

interface QnACustomRepository{

}

public interface QnARepository extends JpaRepository<QnA, Long>,QnACustomRepository {
   
}
