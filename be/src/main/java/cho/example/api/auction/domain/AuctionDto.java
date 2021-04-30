package cho.example.api.auction.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import cho.example.api.chat.domain.Chat;
import cho.example.api.stock.domain.Item;
import cho.example.api.uss.domain.UserVo;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class AuctionDto implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private long auctionNo;
    private Date regDate;
    private String bidPrice;
    private String currentPrice;
    private String bid;
    private List<UserVo> userVoList;
    private UserVo userVo;
    private Item item;
    private Chat chat;
}
