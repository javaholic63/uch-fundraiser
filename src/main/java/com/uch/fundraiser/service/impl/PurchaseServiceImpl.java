package com.uch.fundraiser.service.impl;

import com.uch.fundraiser.entity.Purchase;
import com.uch.fundraiser.respository.PurchaseRepository;
import com.uch.fundraiser.service.PurchaseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PurchaseServiceImpl implements PurchaseService {


    private PurchaseRepository purchaseRepository;

    @Override
    public Purchase createPurchase(Purchase purchase) {
        return  purchaseRepository.save(purchase);
    }

    @Override
    public Purchase getPurchaseById(Long purchaseId) {
        Optional<Purchase> optionalPurchase = purchaseRepository.findById(purchaseId);
        return optionalPurchase.get();
    }

    @Override
    public List<Purchase> getAllPurchases() {
        return purchaseRepository.findAll();
    }

    @Override
    public Purchase updatePurchase(Purchase purchase) {
        Purchase existingPurchase = purchaseRepository.findById(purchase.getPurchaseId()).get();
        existingPurchase.setDonations(purchase.getDonations());
        existingPurchase.setQuantity(purchase.getQuantity());
        existingPurchase.setBidPrice(purchase.getBidPrice());
        existingPurchase.setCost(purchase.getCost());
        Purchase updatedPurchase = purchaseRepository.save(existingPurchase);
        return updatedPurchase;
    }

    @Override
    public void deletePurchase(Long purchaseId) {
        purchaseRepository.deleteById(purchaseId);
    }
}
