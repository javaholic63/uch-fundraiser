package com.uch.fundraiser.respository;


import com.uch.fundraiser.entity.Donation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonationRepository extends JpaRepository<Donation, Long> {

}
