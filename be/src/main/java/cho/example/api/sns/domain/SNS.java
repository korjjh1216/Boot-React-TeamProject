package cho.example.api.sns.domain;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "snsboards")
public class SNS {
    
    @Id
    @GeneratedValue
    @Column(name = "user_name")
    private String userName;
    
    @Column(name = "sns_content")
    private String snsContent;

    @Column(name = "reg_date")
    private String regDate;

    @Column(name = "hit")
    private String hit;
}
