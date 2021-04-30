package cho.example.api.uss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.repository.query.Param;
import cho.example.api.uss.domain.UserVo;


interface UserCustomRepository{
	
}
public interface UserRepository extends JpaRepository<UserVo, Long>,UserCustomRepository {
	@Transactional
	@Query(value="select user_no, username from users where users.username=:username and users.password=:password", nativeQuery = true)
	public String login(@Param("username") String username,@Param("password") String password);
	
   
}
