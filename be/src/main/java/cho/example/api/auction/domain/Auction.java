package cho.example.api.auction.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="auctions")
public class Auction {

    @Id
    @GeneratedValue
    @Column(name="auction_id")
    private long auctionId;

    @Column(name="reg_date")
    private Date regDate;
    
    @Column(name="win_bid")
    private String winBid;

    @Column(name="reserved_pirce")
    private String reservedPrice;

    @Column(name="placed_price")
    private String placedPrice;

}
