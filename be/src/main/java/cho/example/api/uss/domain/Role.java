package cho.example.api.uss.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.util.Arrays;

@RequiredArgsConstructor @Getter
public enum Role implements GrantedAuthority {
    ADMIN("ROLE_ADMIN","관리자권한"),
    USER("ROLE_USER","사용자권한"),
    UNKNOWN("ROLE_UNKNOWN","알수없는 권한");

    private final String role;
    private final String value;

    public static Role of(String role){
        return Arrays.stream(Role.values()).filter(i -> i.getRole().equals(role)).findAny().orElse(UNKNOWN);
    }

    @Override
    public String getAuthority() {
        return name();
    }

}
