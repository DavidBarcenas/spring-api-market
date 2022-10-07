package com.apimarket.web.controller;

import com.apimarket.domain.Product;
import com.apimarket.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping()
    public List<Product> getAll() {
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Product> getProduct(@PathVariable int id) {
        return productService.getProduct(id);
    }

    @GetMapping("/category/{id}")
    public Optional<List<Product>> getByCategory(@PathVariable int id) {
        return productService.getByCategory(id);
    }

    @PostMapping()
    public Product save(@RequestBody Product product) { return productService.save(product); }

    @PutMapping("/{id}")
    public Product edit(@RequestBody Product product, @PathVariable int id) { return productService.edit(product, id); }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") int productId) {
        return productService.delete(productId);
    }
}
