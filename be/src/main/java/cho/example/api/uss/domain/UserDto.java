package cho.example.api.uss.domain;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component 
@Data
public class UserDto implements Serializable {
    private static final long serialVersionUID = 1L;
	private long userNo;
	private String userName;
	private String password;
	private String name;
	private String email;
	private String birthday;
	private String gender;
	private String regDate;
	private String phoneNumber;
}
