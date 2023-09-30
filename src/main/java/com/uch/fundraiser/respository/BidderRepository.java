package com.uch.fundraiser.respository;

import com.uch.fundraiser.entity.Bidder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BidderRepository extends JpaRepository<Bidder, Long> {
}
