package cho.example.api.sns.domain;

import org.springframework.stereotype.Component;

import javassist.SerialVersionUID;
import lombok.Data;

@Component
@Data
public class SNSDto {
    private static final long serialVersionUID = 1L;
    private String userName;
    private String snsContent;
    private String regDate;
    private String hit; //조회수
    
}
