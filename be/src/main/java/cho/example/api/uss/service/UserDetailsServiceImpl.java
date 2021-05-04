package cho.example.api.uss.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service

public class UserDetailsServiceImpl implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println("------------------------------------------");
        System.out.println("------------------------------------------");
        System.out.println(username);
        System.out.println("------------------------------------------");
        System.out.println("------------------------------------------");


        return null;
    }
}
