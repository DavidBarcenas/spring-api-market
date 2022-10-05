package com.apimarket.persistence;

import com.apimarket.persistence.crud.ProductoCrudRepository;
import com.apimarket.persistence.entity.Producto;

import java.util.List;

public class ProductoRepository {
    private ProductoCrudRepository productoCrudRepository;

    public List<Producto> getAll() {
        return (List<Producto>) productoCrudRepository.findAll();
    }
}
