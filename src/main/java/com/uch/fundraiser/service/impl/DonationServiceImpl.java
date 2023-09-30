package com.uch.fundraiser.service.impl;

import lombok.AllArgsConstructor;
import com.uch.fundraiser.entity.Donation;
import com.uch.fundraiser.respository.DonationRepository;
import com.uch.fundraiser.service.DonationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DonationServiceImpl implements DonationService {


    private DonationRepository donationRepository;


    @Override
    public Donation createDonation(Donation donation) {
        return donationRepository.save(donation);
    }

    @Override
    public Donation getDonationById(Long donationId) {
        Optional<Donation> optionalProduct = donationRepository.findById(donationId);
        return optionalProduct.get();
    }

    @Override
    public List<Donation> getAllDonations() {
        return donationRepository.findAll();
    }

    @Override
    public Donation updateDonation(Donation donation) {
        Donation existingDonation = donationRepository.findById(donation.getDonationId()).get();
        existingDonation.setDonor(donation.getDonor());
        existingDonation.setDescription(donation.getDescription());
        existingDonation.setQuantity(donation.getQuantity());
        existingDonation.setAskPrice(donation.getAskPrice());
        Donation updatedDonation = donationRepository.save(existingDonation);
        return updatedDonation;
    }

    @Override
    public void deleteDonation(Long donationId) {
        donationRepository.deleteById(donationId);
    }
}
