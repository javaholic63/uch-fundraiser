package com.uch.fundraiser.service.impl;

import com.uch.fundraiser.entity.Bidder;
import com.uch.fundraiser.respository.BidderRepository;
import com.uch.fundraiser.service.BidderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BidderServiceImpl implements BidderService {


    private BidderRepository bidderRepository;


    @Override
    public Bidder createBidder(Bidder bidder) {
        return bidderRepository.save(bidder);
    }

    @Override
    public Bidder getBidderById(Long bidderId) {
        Optional<Bidder> optionalBidder = bidderRepository.findById(bidderId);
        return optionalBidder.get();
    }

    @Override
    public List<Bidder> getAllBidders() {
        return bidderRepository.findAll();
    }

    @Override
    public Bidder updateBidder(Bidder bidder) {
        Bidder existingBidder = bidderRepository.findById(bidder.getBidderId()).get();
        existingBidder.setFirstName(bidder.getFirstName());
        existingBidder.setLastName(bidder.getLastName());
        existingBidder.setArrived(bidder.getArrived());
        existingBidder.setPhone(bidder.getPhone());
        existingBidder.setEmail(bidder.getEmail());
        Bidder updatedBidder = bidderRepository.save(existingBidder);
        return updatedBidder;
    }

    @Override
    public void deleteBidder(Long bidderId) {
        bidderRepository.deleteById(bidderId);
    }
}
