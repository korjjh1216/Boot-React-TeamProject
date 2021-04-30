package cho.example.api.qnaboard.domain;

import java.util.Date;

import javax.persistence.*;

import cho.example.api.uss.domain.UserVo;
import lombok.Getter;
import lombok.ToString;

@Entity
@ToString
@Getter
@Table(name = "boards")
public class QnA {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "board_no")
    private long boardNo;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "user_name",nullable = false)
    private String userName;

    @Column(name = "reg_date")
    private Date regDate;

    @ManyToOne
    @JoinColumn(name ="user_no")
    UserVo user;

}
