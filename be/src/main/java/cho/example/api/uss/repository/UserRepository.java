package cho.example.api.uss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import cho.example.api.uss.domain.UserVo;

public interface UserRepository extends JpaRepository<UserVo, Long> {

   
}
