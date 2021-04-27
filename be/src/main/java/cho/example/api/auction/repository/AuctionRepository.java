package cho.example.api.auction.repository;

import cho.example.api.auction.domain.Auction;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuctionRepository extends JpaRepository<Auction, Long> {
    
}
