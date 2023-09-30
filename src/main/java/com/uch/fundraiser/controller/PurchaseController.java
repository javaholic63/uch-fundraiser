package com.uch.fundraiser.controller;

import com.uch.fundraiser.entity.Purchase;
import com.uch.fundraiser.service.PurchaseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("fundraiser/api/")
public class PurchaseController {

    private PurchaseService purchaseService;

    @PostMapping("purchase")
    public ResponseEntity<Purchase> createPurchase(@RequestBody Purchase purchase){
        Purchase savedPurchase = purchaseService.createPurchase(purchase);
        return new ResponseEntity<>(savedPurchase, HttpStatus.CREATED);
    }

    @GetMapping("purchase/{id}")
    public ResponseEntity<Purchase> getPurchaseById(@PathVariable("id") Long purchaseId){
        Purchase purchase = purchaseService.getPurchaseById(purchaseId);
        return new ResponseEntity<>(purchase, HttpStatus.OK);
    }

    @GetMapping("purchases")
    public ResponseEntity<List<Purchase>> getAllPurchases(){
        List<Purchase> purchases = purchaseService.getAllPurchases();
        return new ResponseEntity<>(purchases, HttpStatus.OK);
    }

    @PutMapping("purchase/{id}")
    public ResponseEntity<Purchase> updatePurchase(@PathVariable("id") Long purchaseId,
                                                   @RequestBody Purchase purchase){
        purchase.setPurchaseId(purchaseId);
        Purchase updatedPurchase = purchaseService.updatePurchase(purchase);
        return new ResponseEntity<>(updatedPurchase, HttpStatus.OK);
    }

    @DeleteMapping("purchase/{id}")
    public ResponseEntity<String> deletePurchase(@PathVariable("id") Long purchaseId){
        purchaseService.deletePurchase(purchaseId);
        return new ResponseEntity<>("Purchase successfully deleted!", HttpStatus.OK);
    }


}
