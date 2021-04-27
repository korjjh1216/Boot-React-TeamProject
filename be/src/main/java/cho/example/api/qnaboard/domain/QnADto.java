package cho.example.api.qnaboard.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class QnADto implements Serializable {
    private static final long serialVersionUID = 1L;
    public long boardNo;
    public String title;
    public String content;
    public String userName;
    public Date regDate;
}
