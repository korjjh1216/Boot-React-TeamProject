package cho.example.api.uss.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

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
    
   
	@Column(name = "username") 
	private String username;

	@Column(name = "password") 
	private String password;
	
		
	@Column(name = "name")
	private String name;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "birthday")
	private Date birthday;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "reg_date")
	private Date regDate;
    
    @Column(name = "phone_number")
	private String phoneNumber;

    @OneToMany(mappedBy = "user")
	List<QnA> qna = new ArrayList<>();

}
