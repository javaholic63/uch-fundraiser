package com.uch.fundraiser.service;

import com.uch.fundraiser.entity.Donation;

import java.util.List;

public interface DonationService {

    Donation createDonation(Donation donation);

    Donation getDonationById(Long donationId);

    List<Donation> getAllDonations();

    Donation updateDonation(Donation donation);

    void deleteDonation(Long donationId);
}
