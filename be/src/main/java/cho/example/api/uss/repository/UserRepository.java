package cho.example.api.uss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import cho.example.api.uss.domain.UserVo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<UserVo, Long> {
    boolean existsByUsername(String username);
    UserVo findByUsername(String username);


    @Query(value="select username from users where users.username=:username and users.password=:password", nativeQuery = true)
    UserVo login(@Param("username") String username, @Param("password") String password);
   
}
