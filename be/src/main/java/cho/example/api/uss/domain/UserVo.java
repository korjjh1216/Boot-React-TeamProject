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
    
   
	@Column(unique = true ,nullable = false)
	private String username;

	@Size(min=8,message = "Minimum Password Length: 8characters")
	private String password;
	
	@Column(name = "email")
	private String email;

	@Column(name = "name")
	private String name;

    @OneToMany(mappedBy = "user")
	List<QnA> qna = new ArrayList<>();

    @ElementCollection(fetch = FetchType.EAGER)
    List<Role> roles;
}
