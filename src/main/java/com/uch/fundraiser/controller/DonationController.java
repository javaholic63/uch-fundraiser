package com.uch.fundraiser.controller;

import lombok.AllArgsConstructor;
import com.uch.fundraiser.entity.Bidder;
import com.uch.fundraiser.entity.Purchase;
import com.uch.fundraiser.service.BidderService;
import com.uch.fundraiser.service.PurchaseService;
import com.uch.fundraiser.entity.Donation;
import com.uch.fundraiser.service.DonationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("fundraiser/api/")
public class DonationController {

    private DonationService donationService;


    // build create Product REST API
    @PostMapping("donation")
    public ResponseEntity<Donation> createDonation(@RequestBody Donation donation){
        Donation savedDonation = donationService.createDonation(donation);
        return new ResponseEntity<>(savedDonation, HttpStatus.CREATED);
    }

    // build get Donation by id REST API
// http://localhost:8080/api/donations/1
    @GetMapping("donation/{id}")
    public ResponseEntity<Donation> getDonationById(@PathVariable("id") Long donationId){
        Donation donation = donationService.getDonationById(donationId);
        return new ResponseEntity<>(donation, HttpStatus.OK);
    }

    // Build Get All donations REST API
// http://localhost:8080/api/donations
    @GetMapping("donations")
    public ResponseEntity<List<Donation>> getAlldonations(){
        List<Donation> donations = donationService.getAllDonations();
        return new ResponseEntity<>(donations, HttpStatus.OK);
    }


    // Build Update donation REST API
    @PutMapping("donation/{id}")
// http://localhost:8080/api/donations/1
    public ResponseEntity<Donation> updateDonation(@PathVariable("id") Long donationId,
                                                   @RequestBody Donation donation){
        donation.setDonationId(donationId);
        Donation updatedDonation = donationService.updateDonation(donation);
        return new ResponseEntity<>(updatedDonation, HttpStatus.OK);
    }


    // Build Delete Donation REST API
    @DeleteMapping("donation/{id}")
    public ResponseEntity<String> deleteDonation(@PathVariable("id") Long donationId){
        donationService.deleteDonation(donationId);
        return new ResponseEntity<>("Donation successfully deleted!", HttpStatus.OK);
    }

}