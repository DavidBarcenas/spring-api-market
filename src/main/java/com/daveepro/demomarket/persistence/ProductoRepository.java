package com.daveepro.demomarket.persistence;

import com.daveepro.demomarket.persistence.crud.ProductoCrudRepository;
import com.daveepro.demomarket.persistence.entity.Producto;

import java.util.List;

public class ProductoRepository {
    private ProductoCrudRepository productoCrudRepository;

    public List<Producto> getAll() {
        return (List<Producto>)productoCrudRepository.findAll();
    }
}
