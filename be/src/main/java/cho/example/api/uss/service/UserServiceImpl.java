package cho.example.api.uss.service;

import cho.example.api.security.domain.SecurityProvider;
import cho.example.api.security.exception.SecurityRuntimeException;
import cho.example.api.uss.domain.Role;
import cho.example.api.uss.domain.UserDto;
import cho.example.api.uss.domain.UserVo;
import cho.example.api.uss.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService  {
    private final UserRepository userRepo;
    private final PasswordEncoder passwordEncoder;
    private final SecurityProvider provider;
    private final AuthenticationManager manager;
    private final ModelMapper modelmapper;

    @Override
    public String signup(UserVo user) {

        log.info("2222=======================================");
        log.info(""+ user);



        if(!userRepo.existsByUsername(user.getUsername())){
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            List<Role> list = new ArrayList<>();
            list.add(Role.USER);
            user.setRoles(list);
            userRepo.save(user);
            return provider.createToken(user.getUsername(),user.getRoles());
        }else {
            throw new SecurityRuntimeException("Username is already in use", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }
    @Override
    public UserDto login(UserVo user) {
        try {
            UserVo loginedUser= userRepo.login(user.getUsername(),user.getPassword());
            UserDto userDto = modelmapper.map(user,UserDto.class);
            String token = provider.createToken(user.getUsername(),userRepo.findByUsername(user.getUsername()).getRoles());
            log.info("::::::::ISSUED TOKEN::::::::" + token);
            userDto.setToken(token);
            return userDto;
        }catch (Exception e){
            throw new SecurityRuntimeException("Invalid Username /Password supplied", HttpStatus.UNPROCESSABLE_ENTITY);
        }

    }
}
