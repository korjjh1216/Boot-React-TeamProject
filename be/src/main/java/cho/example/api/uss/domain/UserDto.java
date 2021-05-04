package cho.example.api.uss.domain;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component 
@Data
public class UserDto implements Serializable {

	@ApiModelProperty(position = 0)
	private String username;
	@ApiModelProperty(position = 1)
	private String email;
	@ApiModelProperty(position = 2)
	private String password;
	@ApiModelProperty(position = 3)
	private String name;

	@ApiModelProperty(position = 4)
	private String token;
	@ApiModelProperty(position = 5)
	private List<Role> roles;


}
