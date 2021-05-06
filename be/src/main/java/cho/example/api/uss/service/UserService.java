package cho.example.api.uss.service;

import cho.example.api.uss.domain.UserDto;
import cho.example.api.uss.domain.UserVo;

import java.util.List;

public interface UserService {
    String signup(UserVo user);
    UserDto login(UserVo user);
    List<UserVo> findAll(UserVo user);
}
