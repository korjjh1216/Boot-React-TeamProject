package cho.example.api.uss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import cho.example.api.uss.domain.UserVo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<UserVo, Long> {
    boolean existsByUsername(String username);
    UserVo findByUsername(String username);
    List<UserVo> findAll();

    @Query(value="select username from users where users.username=:username and users.password=:password", nativeQuery = true)
    UserVo login(@Param("username") String username, @Param("password") String password);
   
}
