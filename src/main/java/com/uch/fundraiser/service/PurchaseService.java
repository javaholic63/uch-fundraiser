package com.uch.fundraiser.service;

import com.uch.fundraiser.entity.Purchase;

import java.util.List;

public interface PurchaseService {

    Purchase createPurchase(Purchase purchase);

    Purchase getPurchaseById(Long purchaseId);

    List<Purchase> getAllPurchases();

    Purchase updatePurchase(Purchase purchase);

    void deletePurchase(Long purchaseId);
}
