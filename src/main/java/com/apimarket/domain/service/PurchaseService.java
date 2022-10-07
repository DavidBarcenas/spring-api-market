package com.apimarket.domain.service;

import com.apimarket.domain.Purchase;
import com.apimarket.domain.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {
    @Autowired
    PurchaseRepository purchaseRepository;

    public List<Purchase> getAll() {
        return purchaseRepository.getAll();
    };

    public Optional<List<Purchase>> getByClient(String clientId) {
        return purchaseRepository.getClient(clientId);
    }

    public Purchase save(Purchase purchase) {
        return purchaseRepository.save(purchase);
    };
}
