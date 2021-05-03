package cho.example.api.uss.service;

import cho.example.api.uss.domain.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService  {

    @Override
    public Long signup(UserDto user) {
        return null;
    }
}
