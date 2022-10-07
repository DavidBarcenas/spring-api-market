package com.apimarket.domain.repository;

import com.apimarket.domain.Purchase;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {
    List<Purchase> getAll();
    Optional<List<Purchase>> getClient(String clientId);
    Purchase save(Purchase purchase);
}
