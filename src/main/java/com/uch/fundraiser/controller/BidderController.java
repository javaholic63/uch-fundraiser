package com.uch.fundraiser.controller;


import com.uch.fundraiser.entity.Bidder;
import com.uch.fundraiser.service.BidderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("fundraiser/api/")
public class BidderController {

    private BidderService bidderService;

    @PostMapping("bitter")
    public ResponseEntity<Bidder> createFamily(@RequestBody Bidder bidder){
        Bidder savedBidder = bidderService.createBidder(bidder);
        return new ResponseEntity<>(savedBidder, HttpStatus.CREATED);
    }

    @GetMapping("bitter/{id}")
    public ResponseEntity<Bidder> getBitterById(@PathVariable("id") Long familyId){
        Bidder bidder = bidderService.getBidderById(familyId);
        return new ResponseEntity<>(bidder, HttpStatus.OK);
    }

    @GetMapping("bidders")
    public ResponseEntity<List<Bidder>> getAllBidders(){
        List<Bidder> bidders = bidderService.getAllBidders();
        return new ResponseEntity<>(bidders, HttpStatus.OK);
    }

    @PutMapping("bidder/{id}")
    public ResponseEntity<Bidder> updateFamily(@PathVariable("id") Long bidderId,
                                               @RequestBody Bidder bidder){
        bidder.setBidderId(bidderId);
        Bidder updatedBidder = bidderService.updateBidder(bidder);
        return new ResponseEntity<>(updatedBidder, HttpStatus.OK);
    }

    @DeleteMapping("bidder/{id}")
    public ResponseEntity<String> deleteBidder(@PathVariable("id") Long bidderId){
        bidderService.deleteBidder(bidderId);
        return new ResponseEntity<>("Bidder successfully removed from database!", HttpStatus.OK);
    }
}
