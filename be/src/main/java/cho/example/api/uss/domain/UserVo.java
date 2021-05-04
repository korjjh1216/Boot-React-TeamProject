package cho.example.api.uss.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Size;

import cho.example.api.qnaboard.domain.QnA;
import lombok.Data;

@Data
@Entity
@Table( name = "users")
public class UserVo {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="user_no")
	private long userNo;

	@Column(unique = true, nullable = false) private String username;
	@Size(min=8, message = "Minimum Password Length: 8 characters") private String password;
	@Column(unique = true, nullable = false) private String email;
	@Column(unique = true, nullable = false) private String name;
	@ElementCollection(fetch = FetchType.EAGER)
	List<Role> roles;


}
