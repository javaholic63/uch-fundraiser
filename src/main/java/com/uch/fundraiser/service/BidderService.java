package com.uch.fundraiser.service;

import com.uch.fundraiser.entity.Bidder;

import java.util.List;

public interface BidderService {

    Bidder createBidder(Bidder bidder);

    Bidder getBidderById(Long bidderId);

    List<Bidder> getAllBidders();

    Bidder updateBidder(Bidder bidder);

    void deleteBidder(Long bidderId);
}
