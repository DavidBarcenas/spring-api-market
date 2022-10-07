package com.apimarket.web.controller;

import com.apimarket.domain.Purchase;
import com.apimarket.domain.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {
    @Autowired
    PurchaseService purchaseService;

    @GetMapping()
    public ResponseEntity<List<Purchase>> getAll() {
        return new ResponseEntity<>(purchaseService.getAll(), HttpStatus.OK);
    };

    @GetMapping("/client/{id}")
    public ResponseEntity<List<Purchase>> getClient(@PathVariable String id) {
        return purchaseService.getByClient(id).map(purchases -> new ResponseEntity<>(purchases, HttpStatus.OK)
                ).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    };

    @PostMapping()
    public ResponseEntity<Purchase> save(@RequestBody Purchase purchase) {
        return new ResponseEntity<>(purchaseService.save(purchase), HttpStatus.CREATED);
    };
}
